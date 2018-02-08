package com.cjzf.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigClientController
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${spring.datasource.password}")
    private String db;
    @Value("${spring.rabbitmq.password}")
    private String rabbit;

    @Value("${profile}")
    private String profile;

    @GetMapping("/db")
    public String db() {
        return this.db;
    }

    @GetMapping("/rabbit")
    public String rabbit() {
        return this.rabbit;
    }

    @GetMapping("/profile")
    public String hello() {
        return this.profile;
    }
}