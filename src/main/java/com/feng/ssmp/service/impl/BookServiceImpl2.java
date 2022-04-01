package com.feng.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.ssmp.dao.BookDao;
import com.feng.ssmp.domain.Book;
import com.feng.ssmp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl2 implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean insert(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book,new UpdateWrapper<>()) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(new QueryWrapper<>());
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        return bookDao.selectPage(new Page<>(currentPage,pageSize),new QueryWrapper<>());
    }
}
