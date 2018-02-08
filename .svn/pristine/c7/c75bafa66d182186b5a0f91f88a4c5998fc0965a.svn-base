package com.cjzf.service;

import org.springframework.stereotype.Service;

import com.cjzf.dao.BookMapper;
import com.cjzf.entity.Book;
import com.cjzf.entity.BookCriteria;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BookService
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@Service
public class BookService {
    @Resource
    private BookMapper bookMapper;

    public int saveBook(final Book book) {
        return bookMapper.addSelective(book);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(bookMapper.selectByExample(new BookCriteria()));
    }

    public int updateBook(Integer bookId, Book book) {
        book.setBookId(bookId);
        BookCriteria bookCriteria = new BookCriteria();
        BookCriteria.Criteria criteria = bookCriteria.createCriteria();
        criteria.andBookIdEqualTo(bookId);
        return bookMapper.updateByExample(book, bookCriteria);
    }

    public int deleteBook(Integer bookId) {
        return bookMapper.deleteByPrimaryKey(bookId);
    }

    public Book getBook(Integer bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }
}