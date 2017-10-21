package com.princekr.boot;

import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * Created by prince on 2017/10/19.
 */
public interface Banner {

    void printBanner(Environment environment, Class<?> sourceClass, PrintStream out);

    enum Mode {
        OFF,
        CONSOLE,
        LOG
    }
}
