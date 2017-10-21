package com.princekr.boot.autoconfigure;

import com.princekr.boot.SpringBootConfiguration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
public @interface SpringBootApplication {
}
