package com.hzh.mircroservice;

import com.hzh.mircroservice.Dao.BookDao;
import com.hzh.mircroservice.Mapper.BrandMapper;
import com.hzh.mircroservice.pojo.Book;
import com.hzh.mircroservice.pojo.tbBrand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MircroServiceApplicationTests {
    @Autowired
    BookDao bookDao;

    @Test
    void testDao(){
        Book book = bookDao.selectById(1);
        System.out.println(book);
    }

    @Autowired
    DataSource dataSource;

    @Test
    void testSelectAll()throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "select * from tb_brand";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();
        System.out.println(resultSet);
        List<Integer> ids = new ArrayList();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            ids.add(id);
            System.out.println(ids);
        }
        System.out.println(ids);
        pstmt.close();
        connection.close();
    }

    @Test
    void tessSelectAll1() throws IOException {
        // int status = 1;
        // String companyName = "波导手机";
        // String brandName = "波导";
        // String description = "波导手机，手机中的战斗机";
        // int orderd = 50;
        // tbBrand tbb = new tbBrand();
        // tbb.setCompanyName(companyName);
        // tbb.setBrandName(brandName);
        // tbb.setDescription(description);
        // tbb.setOrderd(orderd);
        // tbb.setStatus(status);
        // tbb.setId(10);
        int[] ids = {14, 15, 16};


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // List<tbBrand> brands = brandMapper.selectAll();
        // System.out.println(brands);
        tbBrand brand = brandMapper.selectById(1);
        System.out.println(brand);
        // brandMapper.add(tbb);
        // System.out.println(tbb.getId());
        // int count = brandMapper.update(tbb);
        // System.out.println(count);
        // brandMapper.deleteById(ids);
        // sqlSession.commit();

        sqlSession.close();

    }

    @Test
    void contextLoads() {
    }

}
