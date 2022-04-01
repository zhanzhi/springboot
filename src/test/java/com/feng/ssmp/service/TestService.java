package com.feng.ssmp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestService {

    @Autowired
    private IBookService bookService;

    @Test
    public void testGetById(){
        Book book = bookService.getById(3);
        System.out.println(book);
    }

    @Test
    public void testDelete(){
        System.out.println(bookService.removeById(14));
    }

    @Test
    public void testPage(){
        Page<Book> page = bookService.page(new Page<>(1, 5), new QueryWrapper<>());
        System.out.println(page.getRecords());
    }
}
