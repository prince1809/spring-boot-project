package com.princekr.boot.autoconfigure;

import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;

import java.util.EventListener;

/**
 * Listener that can be registered with {@code Spring.factories} to receive details of
 * imported auto-configurations.
 * <p>
 * An {@link AutoConfigurationImportListener} may implement any of the following
 * {@link Aware Aware} interfaces, and their respective
 * methods will be called prior to
 * {@link #onAutoConfigurationImportEvent(AutoConfigurationImportEvent)}:
 * <ul>
 * <li>{@link EnvironmentAware}</li>
 * <li>{@link BeanFactoryAware}</li>
 * <li>{@link BeanClassLoaderAware}</li>
 * <li>{@link ResourceLoaderAware}</li>
 * </ul>
 */
@FunctionalInterface
public interface AutoConfigurationImportListener extends EventListener {

    /**
     * Handle an auto-configuration import event.
     *
     * @param event the event to respond to
     */
    void onAutoConfigurationImportEvent(AutoConfigurationImportEvent event);


}
