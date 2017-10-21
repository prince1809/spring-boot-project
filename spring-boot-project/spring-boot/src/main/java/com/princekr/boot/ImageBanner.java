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
public class ImageBanner implements Banner {

    private static final Log logger = LogFactory.getLog(ImageBanner.class);

    private static final double[] RGB_WEIGHT = {0.2126d, 0.7152d, 0.0722d};

    private static final char[] PIXEL = {' ', '.', '*', ':', 'o', '&', '8', '#', '@'};

    private static final int LUMINANCE_INCREMENT = 10;

    private static final int LUMINANCE_START = LUMINANCE_INCREMENT * PIXEL.length;

    private final Resource image;

    public ImageBanner(Resource image) {
        Assert.notNull(image, "Image must not be null");
        Assert.isTrue(image.exists(), "Image must exist");
        this.image = image;
    }

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {

    }
}
