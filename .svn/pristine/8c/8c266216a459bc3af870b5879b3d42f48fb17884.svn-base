package com.cjzf.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.cjzf.util.Constants;
import com.cjzf.web.vo.response.BaseResponse;

/**
 * @ClassName ResponseHandler
 * @Description 响应对象处理器
 * @author nicholas
 * @Date 2018年1月11日 上午11:43:54
 * @version 1.0.1
 */
@Component
@Slf4j
public class ResponseHandler {
    public BaseResponse getBaseResponse(ResponseStatus responseStatus) {
        BaseResponse baseResponse = new BaseResponse();
        if (responseStatus != null) {
            baseResponse.setMessage(responseStatus.getMessage());
            baseResponse.setCode(responseStatus.getCode());
            baseResponse.setData(Constants.NULL_DATA);
        }

        return baseResponse;
    }
}