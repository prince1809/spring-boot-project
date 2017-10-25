package com.princekr.boot.web.embedded.tomcat;

import com.princekr.boot.web.servlet.ServletContextInitializer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * {@link ServletContainerInitializer} used to trigger {@link ServletContainerInitializer
 * ServletContainerInitializers} and track startup errors.
 */
public class TomcatStarter implements ServletContainerInitializer {

    private static final Log logger = LogFactory.getLog(TomcatStarter.class);

    private final ServletContextInitializer[] initializers;

    private volatile Exception startUpException;

    TomcatStarter(ServletContextInitializer[] initializers) {
        this.initializers = initializers;
    }

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        try {
            for (ServletContextInitializer initializer : this.initializers) {
                initializer.onStartup(servletContext);
            }
        } catch (Exception ex) {
            this.startUpException = ex;
            // Prevent Tomcat from logging and re-throwing when we know we can
            // deal with it in the main thread, but log for information here.
            if (logger.isErrorEnabled()) {
                logger.error("Error starting Tomcat context. Exception: "
                        + ex.getClass().getName() + ". Message: " + ex.getMessage());
            }
        }
    }

    public Exception getStartUpException() {
        return this.startUpException;
    }
}
