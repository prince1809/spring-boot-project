package com.princekr.boot;

import groovy.lang.Closure;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by prince on 2017/10/21.
 */
public class BeanDefinitionLoader {

    private final Object[] sources;

    private final AnnotatedBeanDefinitionReader annotatedReader;

    private final XmlBeanDefinitionReader xmlReader;

    //private final BeanDefinitionReader groovyReader;

    private final ClassPathBeanDefinitionScanner scanner;

    private ResourceLoader resourceLoader;

    BeanDefinitionLoader(BeanDefinitionRegistry registry, Object... sources) {
        Assert.notNull(registry, "Registry must not be null");
        Assert.notEmpty(sources, "Sources must not be empty");
        this.sources = sources;
        this.annotatedReader = new AnnotatedBeanDefinitionReader(registry);
        this.xmlReader = new XmlBeanDefinitionReader(registry);
        this.scanner = new ClassPathBeanDefinitionScanner(registry);
        // this.scanner.addExcludeFilter(new Cla);
    }

    public void setBeanNameGenerator(BeanNameGenerator beanNameGenerator) {

    }

    public void setResourceLoader(ResourceLoader resourceLoader) {

    }

    public void setEnvironment(ConfigurableEnvironment environment) {

    }

    public int load() {
        return 0;
    }

    private int load(Object object) {
        return 0;
    }

    private int load(Class<?> source) {
        return 0;
    }

    private int load(GroovyBeanDefinitionSource source) {
        return 0;
    }

    private int load(Resource source) {
        return 0;
    }

    private int load(Package source) {
        return 0;
    }

    private int load(CharSequence source) {
        return 0;
    }

    private boolean isGroovyPresent() {
        return ClassUtils.isPresent("groovy.lang.MetaClass", null);
    }

    private Resource[] findResources(String source) {
        return null;
    }

    private boolean isLoadCandidate(Resource resource) {
        return true;
    }

    private Package findPackage(CharSequence sources) {
        return null;
    }

    private boolean isComponent(Class<?> type) {
        return true;
    }


    /**
     * Simple {@link TypeFilter} used to ensure that specified {@link Class} source are
     * not accidentally re-added during scanning.
     */
    private static class ClassExcludeFilter extends AbstractTypeHierarchyTraversingFilter {

        private final Set<String> classNames = new HashSet<>();

        ClassExcludeFilter(Object... sources) {
            super(false, false);
            for (Object source : sources) {
                if (source instanceof Class<?>) {
                    this.classNames.add(((Class<?>) source).getName());
                }
            }
        }

        @Override
        protected boolean matchClassName(String className) {
            return this.classNames.contains(className);
        }
    }


    /**
     * Source for Bean definition defined in groovy.
     */
    @FunctionalInterface
    protected interface GroovyBeanDefinitionSource {

        Closure<?> getBeans();

    }
}
