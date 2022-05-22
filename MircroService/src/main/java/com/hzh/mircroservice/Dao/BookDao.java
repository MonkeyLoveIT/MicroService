package com.hzh.mircroservice.Dao;

import com.hzh.mircroservice.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {
    @Select("select * from book where id = #{id}")
    Book selectById(int id);

}
