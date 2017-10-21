package com.princekr.boot;

/**
 * Created by prince on 2017/10/21.
 */
public final class SpringBootVersion {

    private SpringBootVersion() {

    }

    public static String getVersion() {
        Package pkg = SpringBootVersion.class.getPackage();
        return (pkg != null ? pkg.getImplementationVersion() : null);
    }
}
