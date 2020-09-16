package com.physics.quesbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QuesbankApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuesbankApplication.class, args);
    }

}
