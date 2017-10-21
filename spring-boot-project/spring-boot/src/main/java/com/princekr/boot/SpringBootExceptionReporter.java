package com.princekr.boot;

import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Callback interface used to support custom reporting if {@link SpringApplication}
 * startup errors. {@link SpringBootExceptionReporter reporters} are loaded via the
 * {@link SpringFactoriesLoader} and must declare a public constructor with a single
 * {@link ConfigurableApplicationContext} parameter.
 */

@FunctionalInterface
public interface SpringBootExceptionReporter {

    /**
     * Report a startup failure to the user.
     * @param failure the source failure
     * @return {@code true} if the failure was reported or {@code false} if default
     * reporting should occur.
     */
    boolean reportException(Throwable failure);
}
