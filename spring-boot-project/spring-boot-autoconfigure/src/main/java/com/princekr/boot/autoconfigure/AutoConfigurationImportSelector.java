package com.princekr.boot.autoconfigure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * {@link DeferredImportSelector} to handle {@link EnableAutoConfiguration
 * auto-configuration}. This class can also be subclassed if a custom variant of
 * {@link EnableAutoConfiguration @EnableAutoConfiguration}. is needed.
 */

public class AutoConfigurationImportSelector
        implements DeferredImportSelector, BeanClassLoaderAware, ResourceLoaderAware,
        BeanFactoryAware, EnvironmentAware, Ordered {

    private static final String[] NO_IMPORTS = {};

    private static final Log logger = LogFactory.getLog(AutoConfigurationImportSelector.class);

    private ConfigurableListableBeanFactory beanFactory;

    private Environment environment;

    private ClassLoader beanClassLoader;

    private ResourceLoader resourceLoader;

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[0];
    }

    protected boolean isEnabled(AnnotationMetadata metadata) {
        return false;
    }

    protected AnnotationAttributes getAttributes(AnnotationMetadata metadata) {
        return null;
    }

    private Class<?> getAnnotationClass() {
        return null;
    }

    protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
        return null;
    }

    protected Class<?> getSpringFactoriesLoaderFactoryClass() {
        return null;
    }

    private void checkExcludedClasses(List<String> configurations, Set<String> exclusions) {
        return;
    }

    protected void handleInvalidExcludes(List<String> invalidExcludes) {

    }

    protected Set<String> getExclusions(AnnotationMetadata metadata, AnnotationAttributes attributes) {
        return null;
    }

    private List<String> getExcludeAutoConfigurationsProperty() {
        return null;
    }

    private List<String> sort(List<String> configurations,
                              AutoConfigurationMetadata autoConfigurationMetadata) throws IOException {
        return null;
    }

    private List<String> filter(List<String> configurations,
                                AutoConfigurationMetadata autoConfigurationMetadata) {
        return null;
    }

    protected List<AutoConfigurationImportFilter> getAutoConfigurationImportFilters() {
        return null;
    }

    private MetadataReaderFactory getMetaDataReaderFactory() {
        return null;
    }

    protected final <T> List<T> removeDuplicates(List<T> list) {
        return null;
    }

    protected final List<String> asList(AnnotationAttributes attributes, String name) {
        return null;
    }

    private void fireAutoConfigurationImportEvents(List<String> configurations) {

    }

    protected List<AutoConfigurationImportListener> getAutoConfigurationImportListeners() {
        return null;
    }

    private void invokeAwareMethods(Object instance) {

    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    protected final ConfigurableListableBeanFactory getBeanFactory() {
        return this.beanFactory;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }

    protected ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    protected final Environment getEnvironment() {
        return this.environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    protected final ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 1;
    }
}
