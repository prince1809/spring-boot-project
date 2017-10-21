package com.princekr.boot;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link UncaughtExceptionHandler} to supress handling already logged exceptions and
 * dealing with system exit.
 */
public class SpringBootExceptionHandler implements UncaughtExceptionHandler {

    private static Set<String> LOG_CONFIGURATION_MESSAGES;

    static {
        Set<String> messages = new HashSet<>();
        messages.add("Logback configuration error detected");
        LOG_CONFIGURATION_MESSAGES = Collections.unmodifiableSet(messages);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {

    }
}
