package com.princekr.boot.web.server;

import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Abstract base class for {@link ConfigurableWebServerFactory} implementations
 */
public class AbstractConfigurableWebServerFactory
        implements ConfigurableWebServerFactory {

    private int port = 8080;

    private InetAddress address;

    private Set<ErrorPage> errorPages = new LinkedHashSet<>();

    private Ssl ssl;

    private SslStoreProvider sslStoreProvider;

    private Compression compression;

    private String serverHeader;

    /**
     * Create a new {@link AbstractConfigurableWebServerFactory} instance.
     */
    public AbstractConfigurableWebServerFactory() {
    }

    /**
     * Create a new {@link AbstractConfigurableWebServerFactory} instance with the
     * specified port.
     *
     * @param port the port number for the web server
     */
    public AbstractConfigurableWebServerFactory(int port) {
        this.port = port;
    }

    /**
     * The port that the web server listens on.
     *
     * @return the port
     */
    public int getPort() {
        return this.port;
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Return the address that the web server binds to.
     *
     * @return the address
     */
    public InetAddress getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(InetAddress address) {
        this.address = address;
    }

    /**
     * Return a mutable set of {@link ErrorPage ErrorPages} that will be used when
     * handling exceptions.
     *
     * @return the error pages
     */
    public Set<ErrorPage> getErrorPages() {
        return this.errorPages;
    }

    @Override
    public void setErrorPages(Set<? extends ErrorPage> errorPages) {
        Assert.notNull(errorPages, "ErrorPages must not be null");
        this.errorPages = new LinkedHashSet<>(errorPages);
    }

    @Override
    public void addErrorPages(ErrorPage... errorPages) {
        Assert.notNull(errorPages, "ErrorPages must not be null");
        this.errorPages.addAll(Arrays.asList(errorPages));
    }

    public Ssl getSsl() {
        return this.ssl;
    }

    @Override
    public void setSsl(Ssl ssl) {
        this.ssl = ssl;
    }

    public SslStoreProvider getSslStoreProvider() {
        return this.sslStoreProvider;
    }

    @Override
    public void setSslStoreProvider(SslStoreProvider sslStoreProvider) {
        this.sslStoreProvider = sslStoreProvider;
    }

    public Compression getCompression() {
        return this.compression;
    }

    @Override
    public void setCompression(Compression compression) {
        this.compression = compression;
    }

    public String getServerHeader() {
        return this.serverHeader;
    }

    @Override
    public void setServerHeader(String serverHeader) {
        this.serverHeader = serverHeader;
    }

    /**
     * Return the absolute temp dir for given web server.
     *
     * @param prefix server name
     * @return The temp dir for given server.
     */
    protected final File createTempDir(String prefix) {
        try {
            File tempDir = File.createTempFile(prefix + ".", "." + getPort());
            tempDir.delete();
            tempDir.mkdir();
            tempDir.deleteOnExit();
            return tempDir;
        } catch (IOException ex) {
            throw new WebServerException(
                    "Unable to create tempDir. java.io.tmpDir is set to "
                            + System.getProperty("java.io.tmpdir"),
                    ex);
        }
    }
}
