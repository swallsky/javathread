package com.com.jdbc;

import java.sql.*;

public class MysqlTest {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dream-boot?useSSL=false", "root", "password123");
        String sql = "select * from da_user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getString("username"));
        }
        statement.close(); //关闭
        connection.close();
    }
}
