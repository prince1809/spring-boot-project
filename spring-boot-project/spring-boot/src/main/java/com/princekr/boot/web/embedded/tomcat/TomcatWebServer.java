package com.princekr.boot.web.embedded.tomcat;

import com.princekr.boot.web.server.WebServer;
import com.princekr.boot.web.server.WebServerException;
import org.apache.catalina.Container;
import org.apache.catalina.Context;
import org.apache.catalina.Engine;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.naming.ContextBindings;
import org.springframework.util.Assert;

import javax.naming.NamingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link WebServer} that can be used to control a Tomcat web server. Usually this class
 * should be created using the {@link TomcatReactiveWebServerFactory} not directly.
 *
 * @since 2.0.0
 */
public class TomcatWebServer implements WebServer {

    private static final Log logger = LogFactory.getLog(TomcatWebServer.class);

    private static final AtomicInteger containerCounter = new AtomicInteger(-1);

    private final Object monitor = new Object();

    private final Map<Service, Connector[]> serviceConnectors = new HashMap<>();

    private final Tomcat tomcat;

    private final boolean autoStart;

    private volatile boolean started;

    /**
     * Create a new {@link TomcatWebServer} instance.
     *
     * @param tomcat the underlying Tomcat server
     */
    public TomcatWebServer(Tomcat tomcat) {
        this(tomcat, true);
    }

    /**
     * Create a new {@link TomcatWebServer} instance.
     *
     * @param tomcat    the underlying Tomcat server
     * @param autoStart if the server should be started
     */
    public TomcatWebServer(Tomcat tomcat, boolean autoStart) {
        Assert.notNull(tomcat, "Tomcat server must not be null");
        this.tomcat = tomcat;
        this.autoStart = autoStart;
        initialize();
    }

    private void initialize() throws WebServerException {
        TomcatWebServer.logger.info("Tomcat initialized with port(s): " + getPortsDescription(false));
        synchronized (this.monitor) {
            try {
                addInstanceIdToEngineName();

                // Remove service connectors so that protocol binding doesn't happen yet
                removeServiceConnectors();

                this.tomcat.start();

                // We can re-throw failure exception directly in the main thread
                rethrowDeferredStartupException();

                Context context = findContext();

                try {
                    ContextBindings.bindClassLoader(context, context.getNamingToken(), getClass().getClassLoader());
                } catch (NamingException ex) {
                    // Naming is not enabled. Continue
                }

                // Unlike Jetty, all Tomcat threads are daemon threads. We create a
                // blocking non-daemon to stop immediate shutdown
                startDaemonAwaitThread();

            } catch (Exception ex) {
                throw new WebServerException("Unable to start embedded Tomcat", ex);
            }
        }

    }

    private Context findContext() {
        for (Container child : this.tomcat.getHost().findChildren()) {
            if (child instanceof Context) {
                return (Context) child;
            }
        }
        throw new IllegalStateException("The host does not contain a context");
    }

    private void addInstanceIdToEngineName() {
        int instanceId = containerCounter.incrementAndGet();
        if (instanceId > 0) {
            Engine engine = this.tomcat.getEngine();
            engine.setName(engine.getName() + "-" + instanceId);
        }
    }

    private void removeServiceConnectors() {
        for (Service service : this.tomcat.getServer().findServices()) {
            Connector[] connectors = service.findConnectors().clone();
            this.serviceConnectors.put(service, connectors);
            for (Connector connector : connectors) {
                service.removeConnector(connector);
            }
        }
    }

    private void rethrowDeferredStartupException() throws Exception {
        Container[] children = this.tomcat.getHost().findChildren();
        for (Container container : children) {
            //if (container instanceof Tomcat)
        }
    }

    private void startDaemonAwaitThread() {

    }

    @Override
    public void start() throws WebServerException {

    }

    private void checkThatConnectorsHaveStarted() {

    }

    private void stopSilently() {

    }

    private void stopTomcat() throws LifecycleException {

    }

    private void addPreviouslyRemovedConnectors() {

    }

    private void stopProtocolHandler(Connector connector) {

    }

    private void startConnector(Connector connector) {

    }

    Map<Service, Connector[]> getServiceConnectors() {
        return this.serviceConnectors;
    }

    @Override
    public void stop() throws WebServerException {

    }

    private String getPortsDescription(boolean localPort) {
        StringBuilder ports = new StringBuilder();
        for (Connector connector : this.tomcat.getService().findConnectors()) {
            ports.append(ports.length() == 0 ? "" : " ");
            int port = (localPort ? connector.getLocalPort() : connector.getPort());
            ports.append(port + " (" + connector.getScheme() + ")");
        }
        return ports.toString();
    }

    @Override
    public int getPort() {
        Connector connector = this.tomcat.getConnector();
        if (connector != null) {
            return connector.getLocalPort();
        }
        return 0;
    }

    /**
     * Return access to the underlying Tomcat server.
     *
     * @return the Tomcat server
     */
    public Tomcat getTomcat() {
        return this.tomcat;
    }
}
