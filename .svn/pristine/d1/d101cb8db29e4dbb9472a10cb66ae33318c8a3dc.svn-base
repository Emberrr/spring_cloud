package com.cjzf.web.controller;

import com.cjzf.Zuul;
import com.cjzf.exception.ResponseStatus;
import com.cjzf.web.vo.response.BaseResponse;
import com.cjzf.web.vo.security.LoginParameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Zuul.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@Slf4j
public class JWTControllerTest {
    private static final Logger log = LoggerFactory.getLogger(JWTControllerTest.class);
    
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAccessToken() throws Exception {
        String jsonString = "{\n" +
                "  \"client_id\": \"098f6bcd4621d373cade4e832627b4f6\",\n" +
                "  \"password\": \"nicholas\",\n" +
                "  \"user_name\": \"nicholas\"\n" +
                "}";
        log.info("jsonString is: {}", jsonString);

        LoginParameter parameter = OBJECT_MAPPER.readValue(jsonString, LoginParameter.class);

        BaseResponse actual = template.postForObject("/oauth/token", parameter, BaseResponse.class);

        assertThat(actual.getCode(), equalTo(ResponseStatus.OK.getCode()));
        assertThat(actual.getMessage(), equalTo(ResponseStatus.OK.getMessage()));
        //assertThat(((HashMap) actual.getData()).get("expires_in"), equalTo(7200));
        //assertThat(((HashMap) actual.getData()).get("token_type"), equalTo(Constants.BEARER));
    }

    @Test
    public void getAccessToken_EMPTY_CLIENT_ID() throws Exception {
        String jsonString = "{\n" +
                "  \"client_id\": \"\",\n" +
                "  \"password\": \"nicolas\",\n" +
                "  \"user_name\": \"nicholas\"\n" +
                "}";
        log.info("jsonString is: {}", jsonString);

        LoginParameter parameter = OBJECT_MAPPER.readValue(jsonString, LoginParameter.class);

        BaseResponse actual = template.postForObject("/oauth/token", parameter, BaseResponse.class);

        assertThat(actual.getCode(), equalTo(ResponseStatus.PARAMETER_VALIDATION.getCode()));
        assertThat(actual.getMessage(), containsString("clientId:不能为空"));
    }

    @Test
    public void getAccessToken_EMPTY_USER_NAME() throws Exception {
        String jsonString = "{\n" +
                "  \"client_id\": \"098f6bcd4621d373cade4e832627b4f6\",\n" +
                "  \"password\": \"nicholas\",\n" +
                "  \"user_name\": \"\"\n" +
                "}";
        log.info("jsonString is: {}", jsonString);
        LoginParameter parameter = OBJECT_MAPPER.readValue(jsonString, LoginParameter.class);

        BaseResponse actual = template.postForObject("/oauth/token", parameter, BaseResponse.class);

        assertThat(actual.getCode(), equalTo(ResponseStatus.PARAMETER_VALIDATION.getCode()));
        assertThat(actual.getMessage(), containsString("userName:不能为空"));
    }

    @Test
    public void getAccessToken_EMPTY_PASSWORD() throws Exception {
        String jsonString = "{\n" +
                "  \"client_id\": \"098f6bcd4621d373cade4e832627b4f6\",\n" +
                "  \"password\": \"\",\n" +
                "  \"user_name\": \"nicholas\"\n" +
                "}";
        log.info("jsonString is: {}", jsonString);
        LoginParameter parameter = OBJECT_MAPPER.readValue(jsonString, LoginParameter.class);

        BaseResponse actual = template.postForObject("/oauth/token", parameter, BaseResponse.class);

        assertThat(actual.getCode(), equalTo(ResponseStatus.PARAMETER_VALIDATION.getCode()));
        assertThat(actual.getMessage(), containsString("password:不能为空"));
    }

    @Test
    public void getAccessToken_NULL_CLIENT_ID() throws Exception {
        String jsonString = "{\n" +
                "  \"client_id\":null,\n" +
                "  \"password\": \"nicholas\",\n" +
                "  \"user_name\": \"nicholas\"\n" +
                "}";
        log.info("jsonString is: {}", jsonString);
        LoginParameter parameter = OBJECT_MAPPER.readValue(jsonString, LoginParameter.class);

        BaseResponse actual = template.postForObject("/oauth/token", parameter, BaseResponse.class);

        assertThat(actual.getCode(), equalTo(ResponseStatus.PARAMETER_VALIDATION.getCode()));
        assertThat(actual.getMessage(), containsString("clientId:不能为空"));
        assertThat(actual.getMessage(), containsString("clientId:不能为null"));
    }

    @Test
    public void getAccessToken_NULL_USER_NAME() throws Exception {
        String jsonString = "{\n" +
                "  \"client_id\": \"098f6bcd4621d373cade4e832627b4f6\",\n" +
                "  \"password\": \"nicholas\",\n" +
                "  \"user_name\":null\n" +
                "}";
        log.info("jsonString is: {}", jsonString);
        LoginParameter parameter = OBJECT_MAPPER.readValue(jsonString, LoginParameter.class);

        BaseResponse actual = template.postForObject("/oauth/token", parameter, BaseResponse.class);

        assertThat(actual.getCode(), equalTo(ResponseStatus.PARAMETER_VALIDATION.getCode()));
        assertThat(actual.getMessage(), containsString("userName:不能为空"));
        assertThat(actual.getMessage(), containsString("userName:不能为null"));
    }

    @Test
    public void getAccessToken_NULL_PASSWORD() throws Exception {
        String jsonString = "{\n" +
                "  \"client_id\": \"098f6bcd4621d373cade4e832627b4f6\",\n" +
                "  \"password\":null,\n" +
                "  \"user_name\": \"nicholas\"\n" +
                "}";
        log.info("jsonString is: {}", jsonString);
        LoginParameter parameter = OBJECT_MAPPER.readValue(jsonString, LoginParameter.class);

        BaseResponse actual = template.postForObject("/oauth/token", parameter, BaseResponse.class);

        assertThat(actual.getCode(), equalTo(ResponseStatus.PARAMETER_VALIDATION.getCode()));
        assertThat(actual.getMessage(), containsString("password:不能为空"));
        assertThat(actual.getMessage(), containsString("password:不能为null"));
    }

    @Test
    public void getAccessToken_INVALID_CLIENT_ID() throws Exception {
        String jsonString = "{\n" +
                "  \"client_id\": \"098f6bcd4621d373cade4e832627b4f7\",\n" +
                "  \"password\": \"nicholas\",\n" +
                "  \"user_name\": \"nicholas\"\n" +
                "}";
        log.info("jsonString is: {}", jsonString);
        LoginParameter parameter = OBJECT_MAPPER.readValue(jsonString, LoginParameter.class);

        BaseResponse actual = template.postForObject("/oauth/token", parameter, BaseResponse.class);

        assertThat(actual.getCode(), equalTo(ResponseStatus.INVALID_CLIENT_ID.getCode()));
        assertThat(actual.getMessage(), equalTo(ResponseStatus.INVALID_CLIENT_ID.getMessage()));
    }

    @Test
    public void getAccessToken_INVALID_USER_NAME() throws Exception {
        String jsonString = "{\n" +
                "  \"client_id\": \"098f6bcd4621d373cade4e832627b4f6\",\n" +
                "  \"password\": \"nicholas\",\n" +
                "  \"user_name\": \"nicholas1\"\n" +
                "}";
        log.info("jsonString is: {}", jsonString);
        LoginParameter parameter = OBJECT_MAPPER.readValue(jsonString, LoginParameter.class);

        BaseResponse actual = template.postForObject("/oauth/token", parameter, BaseResponse.class);

        assertThat(actual.getCode(), equalTo(ResponseStatus.INVALID_USER_NAME.getCode()));
        assertThat(actual.getMessage(), equalTo(ResponseStatus.INVALID_USER_NAME.getMessage()));
    }

    @Test
    public void getAccessToken_INVALID_PASSWORD() throws Exception {
        String jsonString = "{\n" +
                "  \"client_id\": \"098f6bcd4621d373cade4e832627b4f6\",\n" +
                "  \"password\": \"nicholas1\",\n" +
                "  \"user_name\": \"nicholas\"\n" +
                "}";
        log.info("jsonString is: {}", jsonString);
        LoginParameter parameter = OBJECT_MAPPER.readValue(jsonString, LoginParameter.class);

        BaseResponse actual = template.postForObject("/oauth/token", parameter, BaseResponse.class);

        assertThat(actual.getCode(), equalTo(ResponseStatus.INVALID_PASSWORD.getCode()));
        assertThat(actual.getMessage(), equalTo(ResponseStatus.INVALID_PASSWORD.getMessage()));
    }
}