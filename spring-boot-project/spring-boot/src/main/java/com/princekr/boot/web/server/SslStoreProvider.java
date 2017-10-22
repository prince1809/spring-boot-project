package com.princekr.boot.web.server;

import java.security.KeyStore;

/**
 * Interface used to provide SSL key stores for an {@link WebServer} to use. Can be used when
 * file based key store cannot be used.
 */
public interface SslStoreProvider {

    /**
     * Return the key store that should be used.
     * @return the key store to use
     * @throws Exception on load error
     */
    KeyStore getKeyStore() throws Exception;

    /**
     * Return the trust store that should be used.
     * @return the trust store to use
     * @throws Exception on load error
     */
    KeyStore getTrustStore() throws Exception;
}
