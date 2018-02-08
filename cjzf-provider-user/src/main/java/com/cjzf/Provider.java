package com.cjzf;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan("com.cjzf.dao")
@Slf4j
public class Provider {
    private static final Logger log = LoggerFactory.getLogger(Provider.class);
    
    public static void main(String[] args) {
        log.info("start execute Provider....\n");
        SpringApplication.run(Provider.class, args);
        log.info("end execute Provider....\n");
    }
}