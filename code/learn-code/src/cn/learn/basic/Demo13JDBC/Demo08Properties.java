package cn.learn.basic.Demo13JDBC;
/*
    加载properties配置文件
    IO读取文件，键值对存储到集合
    从集合中以键值对方式获取数据库的连接信息，完成数据库的连接
*/

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Demo08Properties {
    public static void main(String[] args) throws Exception{
        //使用类的加载器，
        InputStream in = Demo08Properties.class.getClassLoader().getResourceAsStream("database.properties");
        System.out.println(in);
        /*FileInputStream fis = new FileInputStream("database.properties");
        System.out.println(fis);*/
        Properties pro = new Properties();
        pro.load(in);
        //获取集合中的键值对
        String driverClass = pro.getProperty("driverClass");
        String url = pro.getProperty("url");
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");
        Class.forName(driverClass);
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println(con);
    }
}
