package com.feng.ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.ssmp.domain.Book;
import com.feng.ssmp.service.IBookService;
import com.feng.ssmp.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if (book.getName().equals("123")){
            throw new IOException();
        }
        boolean flag = bookService.save(book);
        return new R(flag,flag ? "添加成功^_^":"添加失败-_-");
    }

    @DeleteMapping("{id}")
    public R deleteById(@PathVariable("id") Integer id){
       return new R(bookService.removeById(id));
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.update(book));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable("id") Integer id){
        System.out.println("restart..........");
        System.out.println("restart..........");
        System.out.println("restart..........");
        return new R(bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable("currentPage")Integer currentPage
            ,@PathVariable("pageSize")Integer pageSize,Book book){
//        System.out.println(book);
        Page<Book> page = bookService.page(currentPage,pageSize,book);
        if (currentPage > page.getPages()){//补救措施：当前页面大于总页码数，则用总页码数替换当前页码
            page = bookService.page((int) page.getPages(),pageSize,book);
        }
        return new R(page);
    }
}
