package com.princekr.boot.web.embedded.tomcat;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * TLD Skip patterns used by Spring Boot.
 */
final class TldSkipPatterns {

    private static final Set<String> TOMCAT;

    static {
        // Same as Tomcat
        Set<String> patterns = new LinkedHashSet<>();
        patterns.add("ant-*.jar");
        TOMCAT = Collections.unmodifiableSet(patterns);
    }

    private static final Set<String> ADDITIONAL;

    static {
        // Additional typical for Spring Boot applications
        Set<String> patterns = new LinkedHashSet<>();
        patterns.add("antlr-*.jar");
        ADDITIONAL = Collections.unmodifiableSet(patterns);
    }

    static final Set<String> DEFAULT;

    static {
        Set<String> patterns = new LinkedHashSet<>();
        patterns.addAll(TOMCAT);
        patterns.addAll(ADDITIONAL);
        DEFAULT = Collections.unmodifiableSet(patterns);
    }

    private TldSkipPatterns() {

    }
}
