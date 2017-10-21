package com.princekr.boot.sample.simple;

import com.princekr.boot.CommandLineRunner;
import com.princekr.boot.autoconfigure.SpringBootApplication;
import com.princekr.boot.sample.simple.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by prince on 2017/10/20.
 */
@SpringBootApplication
public class SampleSimpleApplication implements CommandLineRunner {

    @Autowired
    private HelloWorldService helloWorldService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.helloWorldService.getHelloMessage());
        if (args.length > 0 && args[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {

    }
}
