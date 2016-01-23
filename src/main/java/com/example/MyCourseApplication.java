package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration

public class MyCourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyCourseApplication.class, (String[])args);
    }
}
