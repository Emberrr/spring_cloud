package com.cjzf;

import lombok.extern.slf4j.Slf4j;
import zipkin.server.EnableZipkinServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 *@EnableZipkinStreamServer(存储到数据库)
 *@EnableZipkinServer(存储到内存) 
 * */
@SpringBootApplication
//@EnableZipkinStreamServer(存储到数据库)
@EnableZipkinServer
@Slf4j
public class Zipkin {
    private static final Logger log = LoggerFactory.getLogger(Zipkin.class);
    
    public static void main(String[] args) {
        log.info("start execute Zipkin....\n");
        SpringApplication.run(Zipkin.class, args);
        log.info("end execute Zipkin....\n");
    }
}