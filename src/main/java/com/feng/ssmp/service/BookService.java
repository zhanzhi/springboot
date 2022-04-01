package com.feng.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feng.ssmp.domain.Book;

import java.util.List;

public interface BookService {

    boolean insert(Book book);

    boolean deleteById(Integer id);

    boolean update(Book book);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getPage(int currentPage,int pageSize);
}
