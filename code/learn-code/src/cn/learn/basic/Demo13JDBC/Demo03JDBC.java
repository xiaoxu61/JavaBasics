package cn.learn.basic.Demo13JDBC;
/*
    Java程序实现用户登录，用户名和密码，数据库检查
        演示注入攻击
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo03JDBC {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "123";
        Connection con = DriverManager.getConnection(url, username, password);

        Statement stat = con.createStatement();

        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        String pass = sc.nextLine();
        //1' or '1=1 输入后将语句边为  x or true，直接登录成功
        //执行SQL语句，数据表，查询用户名和密码，如果存在，登录成功，不存在登录失败
        String sql = "SELECT * FROM users WHERE username='" + user + "' AND PASSWORD='"+ pass +"'";
        System.out.println(sql);
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("username") + " " + rs.getString("password"));
        }

        rs.close();
        stat.close();
        con.close();
    }
}
