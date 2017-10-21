package com.princekr.boot;

import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * Created by prince on 2017/10/21.
 */
public class SpringBootBanner implements Banner {

    private static final String[] BANNER = {"",
            "  .   ____          _            __ _ _",
            " /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\",
            "( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\",
            " \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )",
            "  '  |____| .__|_| |_|_| |_\\__, | / / / /",
            " =========|_|==============|___/=/_/_/_/"};

    private static final String SPRINT_BOOT = " :: Spring Boot :: ";

    private static final int STRAP_LINE_SIZE = 42;

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream printStream) {
        for (String line : BANNER) {
            printStream.println(line);
        }
        String version = SpringBootVersion.getVersion();
        version = (version == null ? "" : "(" + version+ ")");
        String padding = "";
        while (padding.length() < STRAP_LINE_SIZE - (version.length() + SPRINT_BOOT.length())) {
            padding += " ";
        }

        //printStream.println(Ansi);


    }
}
