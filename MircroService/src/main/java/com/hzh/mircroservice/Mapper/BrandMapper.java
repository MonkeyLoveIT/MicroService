package com.hzh.mircroservice.Mapper;

import com.hzh.mircroservice.pojo.tbBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    // 查询所有
    // @Select("select * from tb_brand")
    List<tbBrand> selectAll();

    @Select("select * from tb_brand;")
    List<tbBrand> selectAll1();

    tbBrand selectById(int id);

    void add(tbBrand brand);

    int update(tbBrand brand);

    void deleteById(@Param("ids")int[] ids);

}
