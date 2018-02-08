package com.cjzf.web.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName BaseResponse
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@Data
@ApiModel(value = "响应消息基础类")
public class BaseResponse {
    @ApiModelProperty(value = "响应码", required = true)
    private int code;
    @ApiModelProperty(value = "响应消息", required = true)
    private String message;
    @ApiModelProperty(value = "返回数据")
    private Object data;
    
    public int getCode() {
        return code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
    
}