package com.princekr.boot;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * Created by prince on 2017/10/20.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
public @interface SpringBootConfiguration {
}
