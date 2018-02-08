package com.cjzf.web.vo.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @ClassName LoginParameter
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@Data
@AllArgsConstructor
@ApiModel(value = "登录参数")
public class LoginParameter {
    @NotNull(message = "不能为null")
    @NotBlank(message = "不能为空")
    @ApiModelProperty(value = "传入的客户端id，相当于微信的openID", required = true)
    @JsonProperty("client_id")
    private String clientId;
    @NotNull(message = "不能为null")
    @NotBlank(message = "不能为空")
    @ApiModelProperty(value = "访问API网关的用户名", required = true)
    @JsonProperty("user_name")
    private String userName;
    @NotNull(message = "不能为null")
    @NotBlank(message = "不能为空")
    @ApiModelProperty(value = "访问API网关的密码", required = true)
    @JsonProperty("password")
    private String password;
    
    
    /**   
    * 创建一个新的实例 LoginParameter.   
    *      
    */   
    
    public LoginParameter() {
        // TODO Auto-generated constructor stub
    }

    public String getClientId() {
        return clientId;
    }
    
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
}