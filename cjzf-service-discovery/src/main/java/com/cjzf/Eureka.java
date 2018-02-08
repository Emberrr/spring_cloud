package com.cjzf;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class Eureka {
    private static final Logger log = LoggerFactory.getLogger(Eureka.class);
    
    public static void main(String[] args) {
        log.info("start execute Eureka....\n");
        SpringApplication.run(Eureka.class, args);
        log.info("end execute Eureka....\n");
    }
}