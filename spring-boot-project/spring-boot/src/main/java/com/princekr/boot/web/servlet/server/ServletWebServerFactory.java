package com.princekr.boot.web.servlet.server;

import com.princekr.boot.web.server.WebServer;
import com.princekr.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.ApplicationContext;

/**
 * Factory instance that can be used to create a {@link WebServer}
 * Created by prince on 2017/10/22.
 */

@FunctionalInterface
public interface ServletWebServerFactory {

    /**
     * Gets a new fully configured but paused {@link WebServer} instance. Clients should
     * not be able to connect to the returned server until {@link WebServer#start()} is
     * called (which happens when the {@link ApplicationContext} has been fully
     * refreshed).
     *
     * @param initializers {@link ServletContextInitializer}s that should be applied as
     *                     the servlet start
     * @return a fully configured and started {@link WebServer}
     * @see WebServer#stop()
     */
    WebServer getWebServer(ServletContextInitializer... initializers);
}
