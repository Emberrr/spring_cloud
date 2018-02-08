package com.cjzf.web.config;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjzf.SpringCloudApplication;
import com.cjzf.util.Constants;
import com.cjzf.web.vo.security.LoginParameter;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCloudApplication.class)
@EnableAutoConfiguration
public class RedisConfigTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate<String, LoginParameter> redisTemplate;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSetStringValue() {
        stringRedisTemplate.opsForValue().set(Constants.BEARER, "111", 60 * 60 * 2, TimeUnit.SECONDS);

        assertThat(stringRedisTemplate.opsForValue().get(Constants.BEARER), equalTo("111"));
    }

    @Test
    public void testSetObjectValue() {
        LoginParameter loginParameter = new LoginParameter();
        loginParameter.setClientId("098f6bcd4621d373cade4e832627b4f6");
        loginParameter.setUserName("Nicholas");
        loginParameter.setPassword("Nicholas");

        ValueOperations<String, LoginParameter> operations = redisTemplate.opsForValue();
        operations.set(Constants.LOGIN_PARAMETER, loginParameter);

        assertThat(operations.get(Constants.LOGIN_PARAMETER).getClientId(), equalTo("098f6bcd4621d373cade4e832627b4f6"));
        assertThat(operations.get(Constants.LOGIN_PARAMETER).getUserName(), equalTo("Nicholas"));
        assertThat(operations.get(Constants.LOGIN_PARAMETER).getPassword(), equalTo("Nicholas"));
    }
}