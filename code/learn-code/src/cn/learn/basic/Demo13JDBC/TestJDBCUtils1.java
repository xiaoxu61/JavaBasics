package cn.learn.basic.Demo13JDBC;

import cn.learn.basic.Demo13JDBC.jdbcutil.JDBCUtilsConfig;

import java.sql.Connection;

public class TestJDBCUtils1 {
    public static void main(String[] args) {
        Connection con = JDBCUtilsConfig.getConnection();
        System.out.println(con);
    }
}
