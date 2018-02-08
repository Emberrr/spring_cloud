package com.cjzf;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableTurbine
@Slf4j
public class Turbine {
    private static final Logger log = LoggerFactory.getLogger(Turbine.class);
    
    public static void main(String[] args) {
        log.info("start execute Turbine....\n");
        SpringApplication.run(Turbine.class, args);
        log.info("end execute Turbine....\n");
    }
}