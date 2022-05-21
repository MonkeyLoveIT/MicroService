package com.hzh.mircroservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MircroServiceApplicationTests {
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
    void contextLoads() {
    }

}
