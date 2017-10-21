package com.princekr.boot.sample.simple;

import com.princekr.boot.ExitCodeGenerator;

/**
 * Created by prince on 2017/10/20.
 */
public class ExitException extends RuntimeException implements ExitCodeGenerator {

    @Override
    public int getExitCode() {
        return 10;
    }
}
