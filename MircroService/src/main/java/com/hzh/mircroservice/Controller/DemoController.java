package com.hzh.mircroservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    DataSource dataSource;

    @GetMapping("test")
    public String testDemo() {
        return "test successful";
    }

    @GetMapping("query")
    public String testSelect() throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "select * from test";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();
        System.out.println(resultSet);
        while (resultSet.next()) {
            System.out.println(resultSet.getRow());
        }
        pstmt.close();
        connection.close();
        return "success";
    }
}
