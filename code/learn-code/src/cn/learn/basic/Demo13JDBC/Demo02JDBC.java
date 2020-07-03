package cn.learn.basic.Demo13JDBC;
/*
    JDBC技术，查询数据表，获取结果集
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo02JDBC {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url, username, password);
        //3.获取执行SQL 语句对象
        Statement state = con.createStatement();
        //拼写查询的SQL
        String sql = "SELECT * FROM sort";
        //4.调用执行者对象方法，执行SQL语句获取结果集
        //ResultSet executeQuery(String sql) 执行SQL语句中的select查询
        //返回值ResultSet接口的实现类对象，实现类在mysql驱动中
        ResultSet rs = state.executeQuery(sql);
        //结果集处理
        //ResultSet接口方法 boolean next() 返回true，有结果集；返回false没有结果集
        while (rs.next()) {
            //获取每列的数据，使用ResultSet接口的方法getXX
            System.out.println(rs.getInt("sid") + "    " + rs.getString("sname")
                        +"   "+ rs.getDouble("sprice") + "    " + rs.getString("sdesc"));
        }
        System.out.println(rs);

        rs.close();
        state.close();
        con.close();
    }
}
