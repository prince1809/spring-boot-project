package com.princekr.boot.web.embedded.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.util.StandardSessionIdGenerator;

/**
 * A specialization of {@link StandardSessionIdGenerator} that initializes
 * {@code SecureRandom} lazily.
 */
public class LazySessionIdGenerator extends StandardSessionIdGenerator {

    protected void startInternal() throws LifecycleException {
        setState(LifecycleState.STARTING);
    }
}
