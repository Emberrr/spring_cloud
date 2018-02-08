package com.cjzf.web.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.cjzf.entity.Book;
import com.cjzf.service.BookConsumerService;
import com.cjzf.util.Constants;
import com.cjzf.web.vo.response.BaseResponse;
import com.cjzf.web.vo.security.LoginParameter;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @ClassName BookConsumerController
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@RestController
@Api(value = "/")
@Slf4j
public class BookConsumerController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(BookConsumerController.class);
    
    @Resource
    private BookConsumerService bookConsumerService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * @param book          传入的book对象实例®
     * @param bindingResult 绑定的验证结果
     * @return 成功或失败信息，json格式封装
     */
    @PostMapping(value = "/consumer/books", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加某本书籍", httpMethod = "POST",
            notes = "添加成功返回bookId",
            response = BaseResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BaseResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public BaseResponse saveBook(@ApiParam(value = "添加的某本书籍信息", required = true) @RequestBody @Valid Book book, BindingResult bindingResult) {
        BaseResponse baseResponse = getValidatedResult(bindingResult);
        if (baseResponse != null) {
            return baseResponse;
        }

        return bookConsumerService.saveBook(Constants.BEARER + " " + stringRedisTemplate.opsForValue().get(Constants.BEARER), book);
    }

    /**
     * @return 成功或失败信息，json格式封装
     */
    @GetMapping(value = "/consumer/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询所有书籍", httpMethod = "GET",
            notes = "查询所有书籍",
            response = BaseResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BaseResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public BaseResponse getBooks() {
        log.info("{} {}", Constants.BEARER, stringRedisTemplate.opsForValue().get(Constants.BEARER));
        return bookConsumerService.getBooks(Constants.BEARER + " " + stringRedisTemplate.opsForValue().get(Constants.BEARER));
    }

    @GetMapping(value = "/consumer/{bookId:[0-9]*}")
    @ApiOperation(value = "获取某本书信息", httpMethod = "GET",
            notes = "成功返回某本书信息",
            response = BaseResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BaseResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public BaseResponse getBook(@ApiParam(value = "书籍ID", required = true) @PathVariable Integer bookId) {
        System.out.println(bookId);
        return bookConsumerService.getBook(Constants.BEARER + " " + stringRedisTemplate.opsForValue().get(Constants.BEARER), bookId);
    }

    @PutMapping(value = "/consumer/books/{bookId:[0-9]*}")
    @ApiOperation(value = "更新某本书籍", httpMethod = "PUT",
            notes = "更新的某本书籍信息",
            response = BaseResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BaseResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public BaseResponse updateBook(@ApiParam(value = "要更新的某本书籍ID", required = true) @PathVariable("bookId") Integer bookId, @ApiParam(value = "要更新的某本书籍信息", required = true) @RequestBody @Valid Book book, BindingResult bindingResult) {
        BaseResponse baseResponse = getValidatedResult(bindingResult);
        if (baseResponse != null) {
            return baseResponse;
        }

        return bookConsumerService.updateBook(Constants.BEARER + " " + stringRedisTemplate.opsForValue().get(Constants.BEARER), bookId, book);
    }

    @DeleteMapping(value = "/consumer/books/{bookId:[0-9]*}")
    @ApiOperation(value = "删除某本书籍信息", httpMethod = "DELETE",
            notes = "删除某本书籍信息",
            response = BaseResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BaseResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public BaseResponse deleteBook(@ApiParam(value = "要删除的某本书籍ID", required = true) @PathVariable("bookId") Integer bookId) {
        return bookConsumerService.deleteBook(Constants.BEARER + " " + stringRedisTemplate.opsForValue().get(Constants.BEARER), bookId);
    }

    @PostMapping(value = "/consumer/oauth/token", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
    public BaseResponse getAccessToken(@ApiParam(value = "登录信息", required = true) @RequestBody LoginParameter loginParameter) {
        return bookConsumerService.getToken(loginParameter);
    }
}