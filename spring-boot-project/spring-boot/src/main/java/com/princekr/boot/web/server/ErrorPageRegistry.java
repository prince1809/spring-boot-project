package com.princekr.boot.web.server;

/**
 * Interface for a registry that holds {@link ErrorPage errorPages}
 */
public interface ErrorPageRegistry {

    /**
     * Adds error pages that will be used when handling exceptions.
     *
     * @param errorPages the error pages
     */
    void addErrorPages(ErrorPage... errorPages);
}
