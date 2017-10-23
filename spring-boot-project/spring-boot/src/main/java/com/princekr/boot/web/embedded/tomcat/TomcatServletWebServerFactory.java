package com.princekr.boot.web.embedded.tomcat;

import com.princekr.boot.web.servlet.server.AbstractServletWebServerFactory;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.Valve;
import org.apache.catalina.connector.Connector;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * {@link AbstractServletWebServerFactory} that can be used to create
 * {@link TomcatWebServer}
 */
public class TomcatServletWebServerFactory extends AbstractServletWebServerFactory
        implements ResourceLoaderAware {

    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private static final Set<Class<?>> NO_CLASSES = Collections.emptySet();

    public static final String DEFAULT_PROTOCOL = "org.apache.coyote.http11.Http11NioProtocol";

    private File baseDirectory;

    private List<Valve> engineValves = new ArrayList<>();

    private List<Valve> contextValves = new ArrayList<>();

    private List<LifecycleListener> contextLifecycleListeners = new ArrayList<>();

    private List<TomcatContextCustomizer> tomcatContextCustomizers  = new ArrayList<>();

    private List<TomcatConnectorCustomizer> tomcatConnectorCustomizers = new ArrayList<>();

    private List<Connector> additionalTomcatConnectors = new ArrayList<>();

    private ResourceLoader resourceLoader;

    private String protocol = DEFAULT_PROTOCOL;

    private Set<String> tldSkipPatterns = new LinkedHashSet<>(TldSkipPatterns.DEFAULT);

    private Charset uriEncoding = DEFAULT_CHARSET;

    private int backgroundProcessorDelay;




    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

    }
}
