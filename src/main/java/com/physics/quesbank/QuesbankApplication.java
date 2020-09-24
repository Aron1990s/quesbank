package com.physics.quesbank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QuesbankApplication {

    protected final static Logger logger = LoggerFactory.getLogger(QuesbankApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(QuesbankApplication.class, args);
        logger.info("~~~乾杯~~梦想已在路上~~ (^_^)／★＼(^_^) ~~道路已在脚下~~乾杯~~~");

    }

}
