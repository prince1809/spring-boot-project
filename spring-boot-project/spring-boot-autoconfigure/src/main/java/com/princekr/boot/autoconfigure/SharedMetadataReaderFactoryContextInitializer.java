package com.princekr.boot.autoconfigure;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;

/**
 * {@link ApplicationContextInitializer} to create a shared
 * {@link CachingMetadataReaderFactory} between the
 * {@link ConfigurationClassPostProcessor} and Spring Boot.
 */
public class SharedMetadataReaderFactoryContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public static final String BEAN_NAME = "com.princekr.boot.autoconfigure." +
            "internalCachingMetadataReaderFactory";

    @Override
    public void initialize(ConfigurableApplicationContext context) {

    }
}
