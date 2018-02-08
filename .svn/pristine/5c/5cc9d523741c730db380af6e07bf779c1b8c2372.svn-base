package com.cjzf.service;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.cjzf.entity.Book;
import com.cjzf.util.Constants;
import com.cjzf.web.vo.response.BaseResponse;
import com.cjzf.exception.ResponseStatus;
import com.cjzf.web.vo.security.LoginParameter;

/**
 * @ClassName BookConsumerService
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@FeignClient(name = "cjzf-api-gateway", fallback = BookConsumerService.FeignClientFallbackFactory.class)
public interface BookConsumerService {
    static final Logger log = LoggerFactory.getLogger(BookConsumerService.class);
    
    @PostMapping(value = "/api-gateway/v1/api/books")
    BaseResponse saveBook(@RequestHeader("Authorization") String authorizationToken,
                          @RequestBody Book book);

    @GetMapping(value = "/api-gateway/v1/api/books")
    BaseResponse getBooks(@RequestHeader("Authorization") String authorizationToken);

    @GetMapping(value = "/api-gateway/v1/api/books/{bookId}")
    BaseResponse getBook(@RequestHeader("Authorization") String authorizationToken,
                         @PathVariable("bookId") Integer bookId);

    @PutMapping(value = "/api-gateway/v1/api/books/{bookId}")
    BaseResponse updateBook(@RequestHeader("Authorization") String authorizationToken,
                            @PathVariable("bookId") Integer bookId,
                            @RequestBody Book book);

    @DeleteMapping(value = "/api-gateway/v1/api/books/{bookId}")
    BaseResponse deleteBook(@RequestHeader("Authorization") String authorizationToken,
                            @PathVariable("bookId") Integer bookId);

    @PostMapping(value = "/oauth/token")
    BaseResponse getToken(@RequestBody LoginParameter loginParameter);

    @Component
    @Slf4j
    class FeignClientFallbackFactory implements FallbackFactory<BookConsumerService> {

        @Override
        public BookConsumerService create(Throwable cause) {
            return new BookConsumerService() {

                /**
                 * hystrix fallback方法
                 *
                 * @param authorizationToken 令牌值
                 * @param book               实体对象
                 * @return 响应消息
                 */
                @Override
                public BaseResponse saveBook(String authorizationToken, Book book) {
                    log.info("{} bookId = {}", Constants.FALL_BACK, book.getBookId());
                    log.info("{} bookName = {}", Constants.FALL_BACK, book.getBookName());
                    log.info("{} publisher = {}", Constants.FALL_BACK, book.getPublisher());
                    return initFallBackResponse();
                }

                /**
                 * hystrix fallback方法
                 *
                 * @param authorizationToken 令牌值
                 * @return 响应消息
                 */
                @Override
                public BaseResponse getBooks(String authorizationToken) {
                    log.info("authorizationToken is:{}", authorizationToken);
                    log.info(Constants.FALL_BACK);
                    return initFallBackResponse();
                }

                /**
                 * hystrix fallback方法
                 *
                 * @param authorizationToken 令牌值
                 * @param bookId             实体对象id
                 * @return 响应消息
                 */
                @Override
                public BaseResponse getBook(String authorizationToken, Integer bookId) {
                    log.info("{} bookId = {}", Constants.FALL_BACK, bookId);
                    return initFallBackResponse();
                }

                /**
                 * hystrix fallback方法
                 *
                 * @param authorizationToken 令牌值
                 * @param bookId             实体对象id
                 * @param book               实体对象
                 * @return 响应消息
                 */
                @Override
                public BaseResponse updateBook(String authorizationToken, Integer bookId, Book book) {
                    log.info("{} bookId = {}", Constants.FALL_BACK, book.getBookId());
                    log.info("{} bookName = {}", Constants.FALL_BACK, book.getBookName());
                    log.info("{} publisher = {}", Constants.FALL_BACK, book.getPublisher());
                    return initFallBackResponse();
                }

                /**
                 * hystrix fallback方法
                 *
                 * @param authorizationToken 令牌值
                 * @param bookId             实体对象id
                 * @return 响应消息
                 */
                @Override
                public BaseResponse deleteBook(String authorizationToken, Integer bookId) {
                    log.info("{} bookId = {}", Constants.FALL_BACK, bookId);
                    return initFallBackResponse();
                }

                /**
                 * hystrix fallback方法
                 *
                 * @param loginParameter 实体对象
                 * @return 响应消息
                 */
                @Override
                public BaseResponse getToken(LoginParameter loginParameter) {
                    log.info("{} clientId = {}", Constants.FALL_BACK, loginParameter.getClientId());
                    log.info("{} userName = {}", Constants.FALL_BACK, loginParameter.getUserName());
                    log.info("{} password = {}", Constants.FALL_BACK, loginParameter.getPassword());
                    return initFallBackResponse();
                }

                /**
                 * 初始化熔断返回的响应消息
                 *
                 * @return 响应消息
                 */
                private BaseResponse initFallBackResponse() {
                    BaseResponse baseResponse = new BaseResponse();
                    baseResponse.setCode(ResponseStatus.FALL_BACK.getCode());
                    baseResponse.setMessage(ResponseStatus.FALL_BACK.getMessage());
                    return baseResponse;
                }
            };
        }
    }
}