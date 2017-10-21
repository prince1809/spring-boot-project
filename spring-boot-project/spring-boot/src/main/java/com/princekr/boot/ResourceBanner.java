package com.princekr.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import java.io.PrintStream;

/**
 * Created by prince on 2017/10/21.
 */
public class ResourceBanner implements Banner {

    private static final Log logger = LogFactory.getLog(ResourceBanner.class);

    private Resource resource;

    public ResourceBanner(Resource resource) {
        Assert.notNull(resource, "Resource must not be null");
        Assert.isTrue(resource.exists(), "Resource must exist");
        this.resource = resource;
    }

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {

    }
}
