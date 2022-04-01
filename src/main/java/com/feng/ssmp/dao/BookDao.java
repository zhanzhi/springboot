package com.feng.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.ssmp.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
