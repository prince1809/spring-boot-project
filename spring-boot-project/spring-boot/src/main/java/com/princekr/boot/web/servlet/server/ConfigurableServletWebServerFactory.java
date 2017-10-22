package com.princekr.boot.web.servlet.server;

import com.princekr.boot.web.server.ConfigurableWebServerFactory;
import com.princekr.boot.web.servlet.ServletContextInitializer;
import io.undertow.util.MimeMappings;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * A configurable {@link ServletWebServerFactory}.
 *
 * @see ServletWebServerFactory
 */
public interface ConfigurableServletWebServerFactory
        extends ConfigurableWebServerFactory, ServletWebServerFactory {

    /**
     * Sets the context path for the web server. The context should start with a "/"
     * character but not end with a "/" character. The default context path can be
     * specified using an empty string.
     *
     * @param contextPath the contextPath to set
     */
    void setContextPath(String contextPath);

    /**
     * Sets the display name of the application displayed in the web server.
     *
     * @param displayName the displayName to set
     */
    void setDisplayName(String displayName);

    /**
     * The session timeout in seconds (default 30 minutes). If 0 or negative then sessions
     * never expire.
     *
     * @param sessionTimeout the session timeout
     */
    void setSessionTimeout(int sessionTimeout);

    /**
     * The session timeout in the specified {@link TimeUnit} (default 30 minutes). If 0 or
     * negative then session never expire.
     *
     * @param sessionTimeout the session timeout
     * @param timeUnit       the time unit
     */
    void setSessionTimeout(int sessionTimeout, TimeUnit timeUnit);

    /**
     * Sets if the session data should be persisted between restarts.
     *
     * @param persistSession {@code true} if session data should be persisted
     */
    void setPersistSession(boolean persistSession);

    /**
     * Set the directory used to store serialized session data.
     *
     * @param sessionStoreDir the directory or {@code null} to use a default location.
     */
    void setSessionStoreDir(File sessionStoreDir);

    /**
     * Set if the DefaultServlet should be registered. Defaults to {@code true} so that
     * files from the {@link #setDocumentRoot(File) document root} will be served.
     *
     * @param registerDefaultServlet if the default servlet should be registered.
     */
    void setRegisterDefaultServlet(boolean registerDefaultServlet);

    /**
     * Sets the mime-type mappings.
     *
     * @param mimeMappings the mime type mappings (defaults to
     *                     {@link MimeMappings#DEFAULT}
     */
    void setMimeMappings(MimeMappings mimeMappings);

    /**
     * Sets the document root directory which will be used by the web context to serve
     * static files.
     *
     * @param documentRoot the document root or {@code null} if not required
     */
    void setDocumentRoot(File documentRoot);

    /**
     * Sets {@link ServletContextInitializer} that should be applied in addition ot
     * {@link ServletWebServerFactory#getWebServer(ServletContextInitializer...)}
     * parameters. This method will replace any previously set or added initializers.
     *
     * @param initializers the initializers to set
     * @see #addInitializers(ServletContextInitializer...)
     */
    void setInitializers(List<? extends ServletContextInitializer> initializers);

    /**
     * Add {@link ServletContextInitializer}s to those that should be applied in addition
     * to {@link ServletWebServerFactory#getWebServer(ServletContextInitializer...)}
     * parameters.
     *
     * @param initializers the initializers to add
     * @see #setInitializers(List)
     */
    void addInitializers(ServletContextInitializer... initializers);

    /**
     * Sets the configuration that will be applied to the server's JSP servlet
     *
     * @param jsp the JSP servlet configuration
     */
    void setJsp(Jsp jsp);

    /**
     * Sets the Locale to charset mappings.
     *
     * @param localeCharsetMappings the Locale to Charset mappings
     */
    void setLocaleCharsetMappings(Map<Locale, Charset> localeCharsetMappings);
}
