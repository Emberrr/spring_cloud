package com.cjzf;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
@Slf4j
public class Config {
    private static final Logger log = LoggerFactory.getLogger(Config.class);
    
    public static void main(String[] args) {
        log.info("start execute Config....\n");
        SpringApplication.run(Config.class, args);
        log.info("end execute ConfigServerApplication....\n");
    }
}