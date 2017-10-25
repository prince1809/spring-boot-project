package com.princekr.boot.autoconfigure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for storing auto-configuration packages for reference later (e.g. by JPA entity
 * scanner).
 */
public abstract class AutoConfigurationPackages {

    private static final Log logger = LogFactory.getLog(AutoConfigurationPackages.class);

    private static final String BEAN = AutoConfigurationPackages.class.getName();

    /**
     * Determine if the auto-configuration base packages for the given bean factory are
     * available.
     *
     * @param beanFactory the source bean factory
     * @return true if there are auto-config packages available
     */
    public static boolean has(BeanFactory beanFactory) {
        return beanFactory.containsBean(BEAN) && !get(beanFactory).isEmpty();
    }

    /**
     * Return the auto-configuration base packages for the given bean factory.
     *
     * @param beanFactory the source bean factory
     * @return a list of auto-configuration packages
     * @throws IllegalStateException of auto-configuration is not enabled.
     */
    public static List<String> get(BeanFactory beanFactory) {
        try {
            return beanFactory.getBean(BEAN, BasePackages.class).get();
        } catch (NoSuchBeanDefinitionException ex) {
            throw new IllegalStateException(
                    "Unable to retrieve @EnableAutoConfiguration base packages");
        }
    }

    /**
     * Programmatically registers the auto-configuration package names. Subsequent
     * invocations will add the given package names to those that have already been
     * regsitered. You can use this method to manually define the base packages that will
     * be used for a given {@link BeanDefinitionRegistry}. Generally it's recommended that
     * you don't call this method directly, but instead rely on the default convention
     * where the package name is set from your {@code @EnableAutoConfiguration}
     * configuration class or classes.
     *
     * @param registry the bean definition registry
     * @param packageNames the package names to set
     */
    public static void register(BeanDefinitionRegistry registry, String... packageNames) {
        if (registry.containsBeanDefinition(BEAN)) {
            BeanDefinition beanDefinition = registry.getBeanDefinition(BEAN);
            ConstructorArgumentValues constructorArguments = beanDefinition.getConstructorArgumentValues();
            constructorArguments.addIndexedArgumentValue(0, addBasePackages(constructorArguments, packageNames));
        } else {

        }
    }

    private static String[] addBasePackages(ConstructorArgumentValues constructorArguments, String[] packageNames) {
        String[] existing  = (String[]) constructorArguments.getIndexedArgumentValue(0, String[].class).getValue();
        //Set<String>
        return null;
    }

    static class Register implements ImportBeanDefinitionRegistrar {

        @Override
        public void registerBeanDefinitions(AnnotationMetadata annotationMetadata,
                                            BeanDefinitionRegistry registry) {
        }
    }

    /**
     * Wrapper for a package import.
     */
    private final static class PackageImport {

        private final String packageName;

        PackageImport(AnnotationMetadata metadata) {
            this.packageName = ClassUtils.getPackageName(metadata.getClassName());
        }

        @Override
        public int hashCode() {
            return this.packageName.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.packageName.equals(((PackageImport) obj).packageName);
        }

        public String getPackageName() {
            return this.packageName;
        }

        @Override
        public String toString() {
            return "Package Import " + this.packageName;
        }
    }

    /**
     * Holder for the base package (name may be null to indicate no scanning).
     */
    static final class BasePackages {

        private final List<String> packages;

        private boolean loggedBasePackageInfo;

        BasePackages(String... names) {
            List<String> packages = new ArrayList<>();
            for (String name : names) {
                if (StringUtils.hasText(name)) {
                    packages.add(name);
                }
            }
            this.packages = packages;
        }

        public List<String> get() {
            if (!this.loggedBasePackageInfo) {
                if (this.packages.isEmpty()) {
                    if (logger.isWarnEnabled()) {
                        logger.warn("@EnableAutoConfiguration was declared on a class" +
                                " in the default package. Automatic @Repository and" +
                                " @Entity scanning is not enabled.");
                    }
                } else {
                    if (logger.isDebugEnabled()) {
                        String packageNames = StringUtils.collectionToCommaDelimitedString(this.packages);
                        logger.debug("@EnableAutoConfiguration was declared on a class" +
                                " in the package '" + packageNames
                                + "'. Automatic @Repository and @Entity scanning is " +
                                "enabled.");
                    }
                }
                this.loggedBasePackageInfo = true;
            }
            return this.packages;
        }
    }
}
