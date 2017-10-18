package com.princekr.boot.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Created by prince on 2017/10/19.
 */
public abstract class AbstractRunMojo extends AbstractDependencyFilterMojo {


    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().debug("Started maven plugin");
    }
}
