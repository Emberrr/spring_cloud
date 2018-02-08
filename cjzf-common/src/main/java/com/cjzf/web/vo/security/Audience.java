package com.cjzf.web.vo.security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName Audience
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@Data
@ConfigurationProperties(prefix = "audience")
@Component
@ApiModel(value = "JWT")
public class Audience {
    @ApiModelProperty(value = "传入的客户端id，相当于微信的openID", required = true)
    private String clientId;
    @ApiModelProperty(value = "64位公钥", required = true)
    private String base64Secret;
    @ApiModelProperty(value = "令牌发行者姓名", required = true)
    private String name;
    @ApiModelProperty(value = "令牌有效时间，单位为秒", required = true)
    private int expiresSecond;
    
    public String getClientId() {
        return clientId;
    }
    
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    
    public String getBase64Secret() {
        return base64Secret;
    }
    
    public void setBase64Secret(String base64Secret) {
        this.base64Secret = base64Secret;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getExpiresSecond() {
        return expiresSecond;
    }
    
    public void setExpiresSecond(int expiresSecond) {
        this.expiresSecond = expiresSecond;
    }
    
}