package com.cjzf.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @ClassName SwaggerConfigOfApiGateway
 * @Description
 * @author nicholas
 * @Date 2018年1月12日 上午10:10:28
 * @version 1.0.1
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigOfApiGateway extends SwaggerConfig {
    @Override
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("gateway")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/oauth/.*"))
                .build();
    }
}
