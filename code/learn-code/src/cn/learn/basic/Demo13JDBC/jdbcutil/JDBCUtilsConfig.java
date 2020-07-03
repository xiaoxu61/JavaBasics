package cn.learn.basic.Demo13JDBC.jdbcutil;
/*
    编写JDBC的工具类，获取数据库的连接
    采用读取配置文件的方式
    读取配置文件，获取连接，执行一次，static{}
*/

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtilsConfig {
    private static Connection con;
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;


    static {
        try {
           readConfig();
        }catch (Exception ex) {
            throw new RuntimeException("数据库连接失败");
        }

    }

    private static void readConfig() throws Exception{
        InputStream in = JDBCUtilsConfig.class.getClassLoader().getResourceAsStream("database.properties");
        Properties pro = new Properties();
        pro.load(in);
        driverClass = pro.getProperty("driverClass");
        url = pro.getProperty("url");
        username = pro.getProperty("username");
        password = pro.getProperty("password");
        Class.forName(driverClass);
        con = DriverManager.getConnection(url, username, password);
    }


    public static Connection getConnection() {
        return con;
    }

}
