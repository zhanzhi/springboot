package com.feng.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feng.ssmp.dao.BookDao;
import com.feng.ssmp.domain.Book;
import com.feng.ssmp.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;


    public Boolean update(Book book){
        return bookDao.update(book,new UpdateWrapper<Book>().eq("id",book.getId())) > 0;
    }

    public Page<Book> page(Integer currentPage,Integer pageSize,Book book){
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        wrapper.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        wrapper.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());

        Page<Book> page = new Page<>(currentPage, pageSize);
        return bookDao.selectPage(page,wrapper);
    }

}
