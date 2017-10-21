package com.princekr.boot.sample.simple.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by prince on 2017/10/20.
 */
@Component
public class HelloWorldService {

    @Value("${name:world}")
    private String name;

    public String getHelloMessage() {
        return "Hello " + this.name;
    }
}
