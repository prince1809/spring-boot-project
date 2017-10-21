package com.princekr.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;

import java.util.*;

/**
 * Created by prince on 2017/10/20.
 */
public class SpringApplication {

    public static final String DEFAULT_CONTEXT_CLASS = "org.springframework.context."
            + "annotation.AnnotationConfigApplicationContext";

    private static final String DEFAULT_WEB_CONTEXT_CLASS = "com.princekr.boot."
            + "web.servlet.context.AnnotationConfigServletWebServerApplicationContext";

    private static final String[] WEB_ENVIRONMENT_CLASSES = {"javax.servlet.Servlet",
            "org.springframework.web.context.ConfigurableWebApplicationContext"};

    private static final String DEFAULT_REACTIVE_WEB_CONTEXT_CLASS = "com.springframework."
            + "boot.web.reactive.context.ReactiveWebServerApplicationContext";

    private static final String REACTIVE_WEB_ENVIRONMENT_CLASS = "org.springframework."
            + "web.reactive.DispatcherHandler";

    private static final String MVC_WEB_ENVIRONMENT_CLASS = "org.springframework."
            + "web.servlet.DispatcherServlet";

    public static final String BANNER_LOCATION_PROPERTY_VALUE = SpringApplicationBannerPrinter.DEFAULT_BANNER_LOCATION;

    public static final String BANNER_LOCATION_PROPERTY = SpringApplicationBannerPrinter.BANNER_LOCATION_PROPERTY;

    private static final String SYSTEM_PROPERTY_JAVA_AWT_HEADLESS = "java.awt.headless";

    private static final Log logger = LogFactory.getLog(SpringApplication.class);

    private Set<Class<?>> primarySources;

    private Set<String> sources = new LinkedHashSet<>();

    private Class<?> mainApplicationClass;

    private Banner.Mode bannerMode = Banner.Mode.CONSOLE;

    private boolean logStartupInfo = true;

    private boolean addCommandLineProperties = true;

    private Banner banner;

    private ResourceLoader resourceLoader;

    private BeanNameGenerator beanNameGenerator;

    private ConfigurableEnvironment environment;

    private Class<? extends ConfigurableApplicationContext> applicationContextClass;

    private WebApplicationType webApplicationType;

    private boolean headless = true;

    private boolean registerShutdownHook = true;

    private List<ApplicationContextInitializer<?>> initializers;

    private List<ApplicationListener<?>> listeners;

    private Map<String, Object> defaultProperties;

    private Set<String> additionalProfiles = new HashSet<>();


    public SpringApplication(Class<?>... primarySources) {

    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public SpringApplication(ResourceLoader resourceLoader, Class<?>... primarySources) {

    }

    private WebApplicationType deduceWebApplicationType() {
        return null;
    }

    private Class<?> deduceMainApplicationClass() {
        return null;
    }

    public ConfigurableApplicationContext run(String... args) {
        return null;
    }

    private ConfigurableEnvironment prepareEnvironment(SpringApplicationRunListeners listeners,
                                                       ApplicationArguments applicationArguments) {
        // create and configure the environment
        return null;
    }

    private void prepareContext(ConfigurableApplicationContext context, ConfigurableEnvironment environment,
                                SpringApplicationRunListeners listeners) {
        return;
    }

    private void refreshContext(ConfigurableApplicationContext context) {

    }

    private void configureHeadlessProperty() {

    }

    private SpringApplicationRunListeners getRunListeners(String[] args) {
        return null;
    }

    private <T> List<T> createSPringFactoriesInstances(Class<T> type, Class<?>[] parameterTypes, ClassLoader classLoader,
                                                       Set<String> names) {
        return null;
    }

    private ConfigurableEnvironment getOrCreateEnvironment() {
        return null;
    }

    private void configureEnvironment(ConfigurableEnvironment environment, String[] args) {

    }

    protected void configurePropertySources(ConfigurableEnvironment environment) {

    }


    protected void configureProfiles(ConfigurableEnvironment environment, String[] args) {

    }

    private void configureIgnoreBeanInfo(ConfigurableEnvironment environment) {

    }

    protected void bindToSpringApplication(ConfigurableEnvironment environment) {

    }

    private Banner printBanner(ConfigurableEnvironment environment) {
        return null;
    }

    protected ConfigurableApplicationContext createApplicationContext() {
        return null;
    }

    protected void postProcessApplicationContext(ConfigurableApplicationContext context) {
        return;
    }

    protected void applyInitializers(ConfigurableApplicationContext context) {

    }

    protected void logStartupInfo(boolean isRoot) {

    }

    protected void logStartupProfileInfo(ConfigurableApplicationContext context) {

    }

    protected Log getApplicationLog() {
        return null;
    }

    protected void load(ApplicationContext context, Object[] sources) {

    }

    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }

    public ClassLoader getClassLoader() {
        return null;
    }


    private BeanDefinitionRegistry getBeanDefinitionRegistry(ApplicationContext context) {
        return null;
    }

    /**
     * Factory method used to create the {@link BeanDefinitionLoader}
     * @param registry the bean definition registry
     * @param sources the sources to load
     * @return the {@link BeanDefinitionLoader} that will be used to load beans
     */
    protected BeanDefinitionLoader createBeanDefinitionLoader(BeanDefinitionRegistry registry, Object[] sources) {
        return new BeanDefinitionLoader(registry, sources);
    }

    protected void refresh(ApplicationContext applicationContext) {

    }

    protected void afterRefresh(ConfigurableApplicationContext context, ApplicationArguments arguments) {

    }

    private void callRunners(ApplicationContext context, ApplicationArguments args) {

    }

    private void callRunner(ApplicationRunner runner, ApplicationArguments args) {

    }

    private void callRunner(CommandLineRunner runner, ApplicationArguments args) {

    }

    private void handleRunFailure(ConfigurableApplicationContext context, SpringApplicationRunListeners listeners,
                                  Collection<SpringBootExceptionReporter> exceptionReporters) {
    }

    private void reportFailure(Collection<SpringBootExceptionReporter> exceptionReporters, Throwable failure) {

    }

    private void registerLoggedException(Throwable exception) {

    }

    private void handleExitCode(ConfigurableApplicationContext context, Throwable exception) {

    }

    private int getExitCodeFromException(ConfigurableApplicationContext context, Throwable exception) {
        return 0;
    }

    private int getExitCodeFromMappedException(ConfigurableApplicationContext context, Throwable exception) {
        return 0;
    }

    private int getExitCodeFromExitCodeGeneratorException(Throwable exception) {
        return 0;
    }

    SpringBootExceptionHandler getSpringBootExceptionHandler() {
        return null;
    }

    private boolean isMainThread(Thread currentThread) {
        return false;
    }

    /**
     * Returns the main application class that has been deduced or explicitly configured.
     * @return the main application class or {@code null}
     */
    public Class<?> getMainApplicationClass() {
        return this.mainApplicationClass;
    }

    /**
     * Set a specific main application class that will be used as a log source and to
     * obtain version information. By default the main application class will be deduced.
     * Can be set to {@code null} if there is no explicit application class.
     * @param mainApplicationClass the mainApplicationClass to set or {@code null}
     */
    public void setMainApplicationClass(Class<?> mainApplicationClass) {
        this.mainApplicationClass = mainApplicationClass;
    }

    /**
     * Returns whether this {@link SpringApplication} is running within a web environment.
     * @return {@code true} if running within a web environment, otherwise {@code false}.
     * @see #setWebEnvironment(boolean)
     * @deprecated since 2.0.0 in favor of {@link #getWebApplicationType}
     */
    @Deprecated
    public boolean isWebEnvironment() {
        return this.webApplicationType == WebApplicationType.SERVLET;
    }

    /**
     * Return the type of web application that is being run.
     * @return the type of web application
     * @since 2.0.0
     */
    public WebApplicationType getWebApplicationType() {
        return this.webApplicationType;
    }

    /**
     * Sets if this application is running within a web environment. If not specified will
     * attempt to deduce the environment based on the classpath.
     * @param webEnvironment if the application is running in a web environment
     * @deprecated  since 2.0.0 in favor or
     * {@link #setWebApplicationType(WebApplicationType)}
     */
    @Deprecated
    public void setWebEnvironment(boolean webEnvironment) {
        this.webApplicationType = webEnvironment ? WebApplicationType.SERVLET : WebApplicationType.NONE;
    }

    public void setWebApplicationType(WebApplicationType webApplicationType) {
        Assert.notNull(webApplicationType, "WebApplicationType must not be null");
        this.webApplicationType = webApplicationType;
    }





}
