package com.princekr.boot.web.server;

/**
 * Simple server-independent abstraction for SSL configuration.
 */
public class Ssl {

    /**
     * Enable SSL Support.
     */
    private boolean enabled = true;

    /**
     * Whether client authentication is wanted ("want) or needed ("need"). Requires a
     * trust store,
     */
    private ClientAuth clientAuth;

    /**
     * Supported SSL ciphers.
     */
    private String[] ciphers;

    /**
     * Enable SSL protocols.
     */
    private String[] enabledProtocols;

    /**
     * Alias that identifies the key in the key store.
     */
    private String keyAlias;

    /**
     * Password used to access the key in the key store.
     */
    private String keyPassword;

    /**
     * Path to the key store that holds the SSL certificate (typically a jks file).
     */
    private String keyStore;

    /**
     * Password used to access the key store.
     */
    private String keyStorePassword;

    /**
     * Type of the key store
     */
    private String keyStoreType;

    /**
     * Provider of the key store.
     */
    private String keyStoreProvider;

    /**
     * Trust store that holds SSL certificates.
     */
    private String trustStore;

    /**
     * Password used to access the trust store.
     */
    private String trustStorePassword;

    /**
     * Type of the trust store.
     */
    private String trustStoreType;

    /**
     * Provider of the trust store.
     */
    private String trustStoreProvider;

    /**
     * SSL protocol to use.
     */
    private String protocol = "TLS";

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ClientAuth getClientAuth() {
        return clientAuth;
    }

    public void setClientAuth(ClientAuth clientAuth) {
        this.clientAuth = clientAuth;
    }

    public String[] getCiphers() {
        return ciphers;
    }

    public void setCiphers(String[] ciphers) {
        this.ciphers = ciphers;
    }

    public String[] getEnabledProtocols() {
        return enabledProtocols;
    }

    public void setEnabledProtocols(String[] enabledProtocols) {
        this.enabledProtocols = enabledProtocols;
    }

    public String getKeyAlias() {
        return keyAlias;
    }

    public void setKeyAlias(String keyAlias) {
        this.keyAlias = keyAlias;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public String getKeyStore() {
        return keyStore;
    }

    public void setKeyStore(String keyStore) {
        this.keyStore = keyStore;
    }

    public String getKeyStorePassword() {
        return keyStorePassword;
    }

    public void setKeyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
    }

    public String getKeyStoreType() {
        return keyStoreType;
    }

    public void setKeyStoreType(String keyStoreType) {
        this.keyStoreType = keyStoreType;
    }

    public String getKeyStoreProvider() {
        return keyStoreProvider;
    }

    public void setKeyStoreProvider(String keyStoreProvider) {
        this.keyStoreProvider = keyStoreProvider;
    }

    public String getTrustStore() {
        return trustStore;
    }

    public void setTrustStore(String trustStore) {
        this.trustStore = trustStore;
    }

    public String getTrustStorePassword() {
        return trustStorePassword;
    }

    public void setTrustStorePassword(String trustStorePassword) {
        this.trustStorePassword = trustStorePassword;
    }

    public String getTrustStoreType() {
        return trustStoreType;
    }

    public void setTrustStoreType(String trustStoreType) {
        this.trustStoreType = trustStoreType;
    }

    public String getTrustStoreProvider() {
        return trustStoreProvider;
    }

    public void setTrustStoreProvider(String trustStoreProvider) {
        this.trustStoreProvider = trustStoreProvider;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Client authentication types.
     */
    public enum ClientAuth {
        /**
         * Client authentication is wanted but not mandatory.
         */
        WANT,

        /**
         * Client authentication is needed but not mandatory.
         */
        NEED
    }
}
