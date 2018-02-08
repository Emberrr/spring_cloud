package com.cjzf.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName TestClient
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@FeignClient("test-service")
public interface TestClient {
    @GetMapping("/test")
    void test();
}
