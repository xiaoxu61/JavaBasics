package cn.learn.basic.Demo13JDBC;
/*
    使用PreparedStatement接口，实现数据表的更新操作
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Demo05JDBC {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "123";
        Connection con = DriverManager.getConnection(url, username, password);

        //拼写修改的SQL语句，采用？占位
        String sql = "UPDATE sort SET sname=?, sprice=? WHERE sid=?";
        //调用数据库的连接对象con方法preparedStatement获取SQL语句的预编译对象
        PreparedStatement pst = con.prepareStatement(sql);
        //调用pst的方法setXXX ? 占位
        pst.setObject(1, "汽车美容");
        pst.setObject(2, 49988);
        pst.setObject(3, 7);
        //调用pst方法执行SQL语句
        pst.executeUpdate();

        pst.close();
        con.close();
    }
}
