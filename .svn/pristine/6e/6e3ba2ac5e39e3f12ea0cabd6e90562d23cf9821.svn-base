package com.cjzf;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 测试步骤:
 * 1. 访问http://localhost:8015/hystrix.stream 可以查看Dashboard
 * 2. 在上面的输入框填入: http://想监控的服务:端口/hystrix.stream进行测试
 * 注意：首先要先调用一下想监控的服务的API，否则将会显示一个空的图表
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
@Slf4j
public class Hystrix {
    private static final Logger log = LoggerFactory.getLogger(Hystrix.class);
    
    public static void main(String[] args) {
        log.info("start execute Hystrix....\n");
        SpringApplication.run(Hystrix.class, args);
        log.info("end execute Hystrix....\n");
    }
}
