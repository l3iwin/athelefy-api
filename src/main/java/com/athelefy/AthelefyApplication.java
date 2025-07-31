package com.athelefy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration
public class AthelefyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthelefyApplication.class, args);
    }

}
