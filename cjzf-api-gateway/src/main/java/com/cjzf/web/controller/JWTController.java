package com.cjzf.web.controller;

import com.cjzf.entity.User;
import com.cjzf.exception.ResponseStatus;
import com.cjzf.service.UserService;
import com.cjzf.util.Constants;
import com.cjzf.util.JwtUtils;
import com.cjzf.web.controller.BaseController;
import com.cjzf.web.vo.response.BaseResponse;
import com.cjzf.web.vo.security.AccessToken;
import com.cjzf.web.vo.security.Audience;
import com.cjzf.web.vo.security.LoginParameter;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @ClassName JWTController
 * @Description
 * @author nicholas
 * @Date 2018年1月12日 上午10:05:21
 * @version 1.0.1
 */
@RestController
@Api(value = "/")
@Slf4j
public class JWTController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(JWTController.class);
    
    @Resource
    private UserService userService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private Audience audience;

    @PostMapping(value = "/oauth/token", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取access_token", httpMethod = "POST",
            notes = "成功返回access_token",
            response = BaseResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BaseResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public BaseResponse getAccessToken(@ApiParam(value = "登录信息", required = true) @RequestBody @Valid LoginParameter loginParameter, BindingResult bindingResult) {
        BaseResponse baseResponse;

        baseResponse = getValidatedResult(bindingResult);
        if (baseResponse != null) {
            return baseResponse;
        }

        baseResponse = isValidClientID(loginParameter, audience);
        if (baseResponse != null) {
            return baseResponse;
        }

        User user = userService.findUserInfoByName(loginParameter.getUserName());
        baseResponse = isValidUserName(user);
        if (baseResponse != null) {
            return baseResponse;
        }

        baseResponse = isValidPassword(loginParameter, user);
        if (baseResponse != null) {
            return baseResponse;
        }

        //拼装accessToken
        String accessToken = JwtUtils.createJWT(loginParameter, user, audience);

        //返回accessToken
        AccessToken accessTokenEntity = new AccessToken();
        accessTokenEntity.setToken(accessToken);
        accessTokenEntity.setExpiresIn(audience.getExpiresSecond());
        accessTokenEntity.setTokenType(Constants.BEARER);

        stringRedisTemplate.opsForValue().set(Constants.BEARER,
                accessToken,
                audience.getExpiresSecond(),
                TimeUnit.SECONDS);
        
        baseResponse = new BaseResponse();
        baseResponse.setCode(ResponseStatus.OK.getCode());
        baseResponse.setMessage(ResponseStatus.OK.getMessage());
        baseResponse.setData(accessTokenEntity);
        
        return baseResponse;
    }
}