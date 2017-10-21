package com.princekr.boot;

/**
 * Created by prince on 2017/10/20.
 */
@FunctionalInterface
public interface ExitCodeGenerator {

    /**
     * Return the exit code that should be returned from the application.
     * @return
     */
    int getExitCode();
}
