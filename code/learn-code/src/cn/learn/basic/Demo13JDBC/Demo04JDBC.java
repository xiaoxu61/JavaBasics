package cn.learn.basic.Demo13JDBC;

/*
    Java程序实现用户登录，用户名和密码，数据库检查
        防止注入共计

        Statement接口实现类，作用执行SQL语句，返回结果集
        有一个子接口PreparedStatement(SQL预编译存储，多次高效的执行SQL)
        PreparedStatement的实现类数据库的驱动中，如何获取接口的实现类
        此方法是Connection数据库连接对象的方法
        PreparedStatement preparedStatement(String sql)
*/

import java.sql.*;
import java.util.Scanner;

public class Demo04JDBC {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "123";
        Connection con = DriverManager.getConnection(url, username, password);

        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        String pass = sc.nextLine();
        //1' or '1=1 输入后将语句边为  x or true，直接登录成功
        //执行SQL语句，数据表，查询用户名和密码，如果存在，登录成功，不存在登录失败
        String sql = "SELECT * FROM users WHERE username=? AND PASSWORD=?";
        //调用Connection接口的方法，preparedStatement，获取preparedStatement接口的实现类
        PreparedStatement pst = con.prepareStatement(sql);
        //调用pst对象的方法，设置问好占位符上的参数
        pst.setObject(1, user);
        pst.setObject(2, pass);
        System.out.println(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("username") + " " + rs.getString("password"));
        }

        rs.close();
        pst.close();
        con.close();
    }
}

