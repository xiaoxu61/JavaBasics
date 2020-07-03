package cn.learn.basic.Demo13JDBC;
/*
 使用PreparedStatement接口 实现数据表的查询操作
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo06JDBC {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "123";
        Connection con = DriverManager.getConnection(url, username, password);

        String sql = "SELECT * FROM sort";
        PreparedStatement pst = con.prepareStatement(sql);

        //调用pst对象的方法，执行查询语句，Select
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("sid") + "  " + rs.getString("sname")
                    + "  " + rs.getString("sprice") + "  " + rs.getString("sdesc"));
        }

        rs.close();
        pst.close();
        con.close();
    }
}
