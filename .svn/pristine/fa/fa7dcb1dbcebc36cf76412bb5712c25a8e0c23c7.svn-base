package com.cjzf.web.config;

import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cjzf.web.filter.HTTPBearerAuthorizeFilter;

/**
 * @ClassName FilterConfig
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@Configuration
@EnableZuulProxy
public class FilterConfig {
    @Bean
    public HTTPBearerAuthorizeFilter accessFilter() {
        return new HTTPBearerAuthorizeFilter();
    }

}