package com.feng.ssmp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feng.ssmp.domain.Book;

public interface IBookService extends IService<Book> {
    Boolean update(Book book);

    Page<Book> page(Integer currentPage, Integer pageSize, Book book);
}
