package com.princekr.boot.autoconfigure;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Indicates that the package containing the annotated class should be registered with
 * {@link AutoConfigurationPackages}
 *
 * @see AutoConfigurationPackages
 * Created by prince on 2017/10/20.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(AutoConfigurationPackages.Register.class)
public @interface AutoConfigurationPackage {

}
