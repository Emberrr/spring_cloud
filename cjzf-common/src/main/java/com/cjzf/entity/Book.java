package com.cjzf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "书籍信息")
public class Book {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column simple_book.bookId
     *
     * @mbggenerated Tue Aug 08 17:20:32 CST 2017
     */
    @JsonIgnore
    @ApiModelProperty(value = "书籍ID，和业务无关，递增", required = true)
    private Integer bookId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column simple_book.bookName
     *
     * @mbggenerated Tue Aug 08 17:20:32 CST 2017
     */
    @NotNull(message = "不能为null")
    @NotBlank(message = "不能为空")
    @ApiModelProperty(value = "书名", required = true)
    private String bookName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column simple_book.publisher
     *
     * @mbggenerated Tue Aug 08 17:20:32 CST 2017
     */
    @NotNull(message = "不能为null")
    @NotBlank(message = "不能为空")
    @ApiModelProperty(value = "出版社名", required = true)
    private String publisher;

    
    public Integer getBookId() {
        return bookId;
    }

    
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    
    public String getBookName() {
        return bookName;
    }

    
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    
    public String getPublisher() {
        return publisher;
    }

    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
}