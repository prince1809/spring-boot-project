package com.princekr.boot;

import org.apache.commons.logging.Log;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prince on 2017/10/21.
 */
public class SpringApplicationBannerPrinter {

    static final String BANNER_LOCATION_PROPERTY = "banner.location";

    static final String BANNER_IMAGE_LOCATION_PROPERTY = "banner.image.location";

    static final String DEFAULT_BANNER_LOCATION = "banner.txt";

    static final String[] IMAGE_EXTENSION = {"gif", "jpg", "png"};

    private static final Banner DEFAULT_BANNER = new SpringBootBanner();

    private final ResourceLoader resourceLoader;

    private final Banner fallbackBanner;

    SpringApplicationBannerPrinter(ResourceLoader resourceLoader, Banner fallbackBanner) {
        this.resourceLoader = resourceLoader;
        this.fallbackBanner = fallbackBanner;
    }

    public Banner print(Environment environment, Class<?> sourceClass, Log logger) {
        Banner banner = getBanner(environment);
        try {
            logger.info(createStringFromBanner(banner, environment, sourceClass));
        } catch (UnsupportedEncodingException ex) {
            logger.warn("Failed to create String for banner", ex);
        }
        return new PrintedBanner(banner, sourceClass);
    }

    public Banner print(Environment environment, Class<?> sourceClass, PrintStream out) {
        Banner banner = getBanner(environment);
        banner.printBanner(environment, sourceClass, out);
        return new PrintedBanner(banner, sourceClass);
    }

    private Banner getBanner(Environment environment) {
        Banners banners = new Banners();
        banners.addIfNotNull(getImageBanner(environment));
        banners.addIfNotNull(getTextBanner(environment));
        if (banners.hasAtleastOneBanner()) {
            return banners;
        }
        if (this.fallbackBanner != null) {
            return this.fallbackBanner;
        }
        return DEFAULT_BANNER;
    }

    private Banner getTextBanner(Environment environment) {
        String location = environment.getProperty(BANNER_LOCATION_PROPERTY, DEFAULT_BANNER_LOCATION);
        Resource resource = this.resourceLoader.getResource(location);
        if (resource.exists()) {
            return new ResourceBanner(resource);
        }
        return null;
    }

    private Banner getImageBanner(Environment environment) {
        String location = environment.getProperty(BANNER_LOCATION_PROPERTY, DEFAULT_BANNER_LOCATION);
        if (StringUtils.hasLength(location)) {
            Resource resource = this.resourceLoader.getResource(location);
            return (resource.exists() ? new ImageBanner(resource) : null);
        }
        for (String ext : IMAGE_EXTENSION) {
            Resource resource = this.resourceLoader.getResource("banner." + ext);
            if (resource.exists()) {
                return new ImageBanner(resource);
            }
        }
        return null;
    }

    private String createStringFromBanner(Banner banner, Environment environment, Class<?> mainApplicationClass)
            throws UnsupportedEncodingException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        banner.printBanner(environment, mainApplicationClass, new PrintStream(baos));
        String charset = environment.getProperty("banner.charset", "UTF-8");
        return baos.toString();
    }

    private static class Banners implements Banner {

        private final List<Banner> banners = new ArrayList<>();

        public void addIfNotNull(Banner banner) {
            if (banner != null) {
                this.banners.add(banner);
            }
        }

        public boolean hasAtleastOneBanner() {
            return !this.banners.isEmpty();
        }

        @Override
        public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
            for (Banner banner : this.banners) {
                banner.printBanner(environment, sourceClass, out);
            }
        }
    }


    private static class PrintedBanner implements Banner {

        private final Banner banner;

        private final Class<?> sourceClass;

        PrintedBanner(Banner banner, Class<?> sourceClass) {
            this.banner = banner;
            this.sourceClass = sourceClass;
        }

        @Override
        public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
            sourceClass = (sourceClass == null ? this.sourceClass : sourceClass);
            this.banner.printBanner(environment, sourceClass, out);
        }
    }
}
