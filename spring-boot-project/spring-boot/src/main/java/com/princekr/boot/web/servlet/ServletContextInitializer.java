package com.princekr.boot.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Implement used to configure a Servlet 3.0+ {@link ServletContext context}
 * programmatically. Unlike {@link}
 */

@FunctionalInterface
public interface ServletContextInitializer {

    /**
     * Configure the given {@link ServletContext} with any servlets, filters, listeners
     * context-params and attributes necessary for initialization.
     *
     * @param servletContext the {@code ServletContext} to initialize
     * @throws ServletException if any call against the given {@code ServletContext}
     * throws a {@code ServletException}
     */
    void onStartup(ServletContext servletContext) throws ServletException;
}
