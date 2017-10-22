package com.princekr.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
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
     *
     * @param registry the bean definition registry
     * @param sources  the sources to load
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
     *
     * @return the main application class or {@code null}
     */
    public Class<?> getMainApplicationClass() {
        return this.mainApplicationClass;
    }

    /**
     * Set a specific main application class that will be used as a log source and to
     * obtain version information. By default the main application class will be deduced.
     * Can be set to {@code null} if there is no explicit application class.
     *
     * @param mainApplicationClass the mainApplicationClass to set or {@code null}
     */
    public void setMainApplicationClass(Class<?> mainApplicationClass) {
        this.mainApplicationClass = mainApplicationClass;
    }

    /**
     * Returns whether this {@link SpringApplication} is running within a web environment.
     *
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
     *
     * @return the type of web application
     * @since 2.0.0
     */
    public WebApplicationType getWebApplicationType() {
        return this.webApplicationType;
    }

    /**
     * Sets if this application is running within a web environment. If not specified will
     * attempt to deduce the environment based on the classpath.
     *
     * @param webEnvironment if the application is running in a web environment
     * @deprecated since 2.0.0 in favor or
     * {@link #setWebApplicationType(WebApplicationType)}
     */
    @Deprecated
    public void setWebEnvironment(boolean webEnvironment) {
        this.webApplicationType = webEnvironment ? WebApplicationType.SERVLET : WebApplicationType.NONE;
    }

    /**
     * Sets the type of web application to be run. If not explicitly set the type of web
     * application will be deduced based on the classpath.
     *
     * @param webApplicationType the web application type
     * @since 2.0.0
     */
    public void setWebApplicationType(WebApplicationType webApplicationType) {
        Assert.notNull(webApplicationType, "WebApplicationType must not be null");
        this.webApplicationType = webApplicationType;
    }

    /**
     * Sets if the application is headless and should not instantiate AWT. Defaults to
     * {@code true} to prevent java icons appearing.
     *
     * @param headless if the application is headless
     */
    public void setHeadless(boolean headless) {
        this.headless = headless;
    }

    /**
     * Sets if the created {@link ApplicationContext} should have  a shutdown hook
     * registered. Default to {@code true} to ensure that JVM shutdowns are handled
     * gracefully.
     *
     * @param registerShutdownHook if the shutdown hook should be registered.
     */
    public void setRegisterShutdownHook(boolean registerShutdownHook) {
        this.registerShutdownHook = registerShutdownHook;
    }

    /**
     * Sets the {@link Banner} instance which will be used to print the banner when no
     * static banner file is provided.
     *
     * @param banner The banner instance to use
     */
    public void setBanner(Banner banner) {
        this.banner = banner;
    }

    /**
     * Sets the mode used to display the banner when the application runs. Defaults to
     * {@code Banner.Mode.CONSOLE}.
     *
     * @param bannerMode the mode used to display the banner
     */
    public void setBannerMode(Banner.Mode bannerMode) {
        this.bannerMode = bannerMode;
    }

    /**
     * Sets if the application information should be logged when the application starts.
     * Defaults to {@code true}
     *
     * @param logStartupInfo if startup info should be logged.
     */
    public void setLogStartupInfo(boolean logStartupInfo) {
        this.logStartupInfo = logStartupInfo;
    }

    /**
     * Sets if a {@link CommandLinePropertySource} should be added to the application
     * context in order to expose arguments. Defaults to {@code true}.
     *
     * @param addCommandLineProperties if command line arguments should be exposed
     */
    public void setAddCommandLineProperties(boolean addCommandLineProperties) {
        this.addCommandLineProperties = addCommandLineProperties;
    }

    /**
     * Set the default environment properties which will be used in addition ot those in the
     * existing {@link Environment}.
     *
     * @param defaultProperties the additional properties to set
     */
    public void setDefaultProperties(Map<String, Object> defaultProperties) {
        this.defaultProperties = defaultProperties;
    }

    /**
     * Convenient alternative to {@link #setDefaultProperties(Map)}.
     *
     * @param defaultProperties some {@link Properties}
     */
    public void setDefaultProperties(Properties defaultProperties) {
        this.defaultProperties = new HashMap<>();
        for (Object key : Collections.list(defaultProperties.propertyNames())) {
            this.defaultProperties.put((String) key, defaultProperties.get(key));
        }
    }


    /**
     * Static helper that can be used to run a {@link SpringApplication} from the
     * specified source using default settings.
     *
     * @param primarySource the primary source to load
     * @param args          the application arguments (usually passed from a Java main method)
     * @return the running {@link ApplicationContext}
     */
    public static ConfigurableApplicationContext run(Class<?> primarySource, String... args) {
        return run(new Class<?>[]{primarySource}, args);
    }

    /**
     * static helper that can be used to run a {@link SpringApplication} from the
     * specified source using default settings and user supplied arguments,
     * @param primarySource the primary source to load.
     * @param args the application arguments (Usually passed from a Java main method)
     * @return the running {@link ApplicationContext}
     */
    public static ConfigurableApplicationContext run(Class<?>[] primarySource, String[] args) {
        return new SpringApplication(primarySource).run(args);
    }

    /**
     * A basic main that can be used to launch an application. This method is useful when
     * application sources are defined via a {@literal --spring.main.sources} command line
     * argument.
     * <p>
     * Most developers will want to define their own main method and call the
     * {@link #run(Class, String...) run} method instead.
     *
     * @param args command line arguments
     * @throws Exception if the application cannot be started
     * @see SpringApplication#run(Class[], String[])
     * @see SpringApplication#run(Class, String...)
     */
    public static void main(String args[]) throws Exception {
        SpringApplication.run(new Class<?>[0], args);
    }

}
