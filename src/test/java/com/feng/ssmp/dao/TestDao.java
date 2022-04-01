package com.feng.ssmp.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestDao {

    @Autowired
    private BookDao bookDao;

    @Test
    public void test1(){
        Book book = bookDao.selectById(1);
        System.out.println(book);
    }

    @Test
    public void testSave(){
        Book book = new Book();
        book.setName("测试数据");
        book.setType("测试");
        book.setDescription("测试数据");
        bookDao.insert(book);
    }

    @Test
    public void testDelete(){
        int delete = bookDao.deleteById(14);
        System.out.println(delete);
    }

    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setId(12);
        book.setDescription("测试数据123");
        int update = bookDao.update(book,new UpdateWrapper<>(book));
        System.out.println(update);
    }

    @Test
    public void testPage(){
        Page<Book> page = new Page<>(2,5);
        Page<Book> bookPage = bookDao.selectPage(page, null);
        System.out.println(bookPage.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
    }

    @Test
    public void testByCondition(){
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("type","化学");
        List<Book> books = bookDao.selectList(wrapper);
        System.out.println(books);
    }

    @Test
    public void testByCondition2(){
        String name = null;
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(name != null,Book::getType,"化学");
        List<Book> books = bookDao.selectList(wrapper);
        System.out.println(books);
    }
}
