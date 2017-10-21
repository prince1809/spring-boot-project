package com.princekr.boot;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created by prince on 2017/10/21.
 */
public interface SpringApplicationRunListener {

    void starting();

    void environmentPrepared(ConfigurableEnvironment environment);

    void contextPrepared(ConfigurableApplicationContext context);

    void contextLoaded(ConfigurableApplicationContext context);

    void finished(ConfigurableApplicationContext context, Throwable exception);
}
