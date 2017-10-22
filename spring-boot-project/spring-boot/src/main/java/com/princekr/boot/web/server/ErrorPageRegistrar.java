package com.princekr.boot.web.server;

/**
 * Interface to be implemented by types that register {@link ErrorPage ErrorPages}.
 */

@FunctionalInterface
public interface ErrorPageRegistrar {

    /**
     * Register pages as required with the given registry.
     * @param registry the error page registry
     */
    void registerErrorPages(ErrorPageRegistry registry);
}
