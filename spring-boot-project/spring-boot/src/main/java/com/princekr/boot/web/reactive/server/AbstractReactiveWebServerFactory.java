package com.princekr.boot.web.reactive.server;

import com.princekr.boot.web.server.AbstractConfigurableWebServerFactory;

/**
 * Abstract base class for {@link ReactiveWebServerFactory} implementations.
 *
 * @since 2.0.0
 */
public abstract class AbstractReactiveWebServerFactory
        extends AbstractConfigurableWebServerFactory
        implements ConfigurableReactiveWebServerFactory {

    public AbstractReactiveWebServerFactory() {
    }

    public AbstractReactiveWebServerFactory(int port) {
        super(port);
    }
}
