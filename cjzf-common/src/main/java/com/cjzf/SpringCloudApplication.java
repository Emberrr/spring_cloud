package com.cjzf;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName SpringCloudApplication
 * @Description
 * @author nicholas
 * @Date 2018年1月12日 上午9:00:34
 * @version 1.0.1
 */
@SpringBootApplication
@Slf4j
public class SpringCloudApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringCloudApplication.class);
    
    public static void main(String[] args) {
        log.info("start execute SpringCloudApplication....\n");
        SpringApplication.run(SpringCloudApplication.class, args);
        log.info("end execute SpringCloudApplication....\n");
    }
}