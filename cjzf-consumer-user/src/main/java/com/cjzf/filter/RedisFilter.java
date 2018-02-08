package com.cjzf.filter;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.ObjectUtils;

import com.cjzf.exception.ResponseStatus;
import com.cjzf.service.BookConsumerService;
import com.cjzf.util.Constants;
import com.cjzf.web.vo.response.BaseResponse;
import com.cjzf.web.vo.security.LoginParameter;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisFilter
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@Order(1)
@WebFilter(filterName = "redisFilter", urlPatterns = {"/consumer/*"},initParams={@WebInitParam(name ="EXCLUDED_PAGES" , value = "/consumer/oauth/token")})
@Slf4j
public class RedisFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(RedisFilter.class);
    
    @Resource
    private BookConsumerService bookConsumerService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate<String, LoginParameter> redisTemplate;

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("=====================RedisFilter init======================");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        log.info("======================Start to execute RedisFilter======================");

        //从redis缓存取token
        String jwtToken = stringRedisTemplate.opsForValue().get(Constants.BEARER);

        ValueOperations<String, LoginParameter> operations = redisTemplate.opsForValue();
        LoginParameter loginParameter = operations.get(Constants.LOGIN_PARAMETER);

        if (!ObjectUtils.isEmpty(jwtToken)) {//若token不为空，则执行controller方法
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //token为空，则向API网关申请新的token
        BaseResponse baseResponse = bookConsumerService.getToken(loginParameter);

        if (baseResponse.getCode() == ResponseStatus.OK.getCode()) {//若API网关成功返回token，则放置在redis缓存中,然后继续执行controller方法
            Map tokenMap = (HashMap) baseResponse.getData();
            log.info("{} {}", Constants.TOKEN_TYPE, tokenMap.get(Constants.TOKEN_TYPE));
            log.info("{} {}", Constants.ACCESS_TOKEN, tokenMap.get(Constants.ACCESS_TOKEN));
            log.info("{} {}", Constants.EXPIRES_IN, tokenMap.get(Constants.EXPIRES_IN));

            stringRedisTemplate.opsForValue().set(Constants.BEARER,
                    (String) tokenMap.get(Constants.ACCESS_TOKEN),
                    ((Integer) tokenMap.get(Constants.EXPIRES_IN)).longValue(),
                    TimeUnit.SECONDS);

            filterChain.doFilter(servletRequest, servletResponse);
        }

        log.info("======================End to execute RedisFilter======================");
    }

    @Override
    public void destroy() {
        log.info("=====================RedisFilter destroy======================");
    }
}