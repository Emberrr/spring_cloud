package com.cjzf.web.vo.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @ClassName AccessToken
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@Data
@ApiModel(value = "访问令牌")
public class AccessToken {
    @NotNull(message = "不能为null")
    @NotBlank(message = "不能为空")
    @ApiModelProperty(value = "访问令牌值", required = true)
    @JsonProperty("access_token")
    private String token;
    @ApiModelProperty(value = "访问令牌类型", required = true)
    @JsonProperty("token_type")
    @NotNull(message = "不能为null")
    @NotBlank(message = "不能为空")
    private String tokenType;
    @ApiModelProperty(value = "令牌有效时间，单位为秒", required = true)
    @JsonProperty("expires_in")
    private long expiresIn;
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getTokenType() {
        return tokenType;
    }
    
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
    
    public long getExpiresIn() {
        return expiresIn;
    }
    
    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
    
}