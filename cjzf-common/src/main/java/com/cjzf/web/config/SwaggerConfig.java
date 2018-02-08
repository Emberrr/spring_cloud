package com.cjzf.web.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2);
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("系统API接口管理")
                .description("各个微服务")
                .contact(new Contact("Nicholas", "", "lippb@yonyou.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0")
                .build();
    }
}