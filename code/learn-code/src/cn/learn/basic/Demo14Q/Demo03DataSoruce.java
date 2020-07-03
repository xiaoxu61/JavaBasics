package cn.learn.basic.Demo14Q;
/*
    连接池jar包中，定义好一个类BasicDataSource
    实现类数据源的规范接口，javax.sql.DataSource
*/

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo03DataSoruce {
    public static void main(String[] args) {
        //创建DataSource接口的实现类对象
        //实现类，org.apache.commons.dbcp
        BasicDataSource dataSource = new BasicDataSource();
        //连接数据库的4个最基本信息，通过对象方法setXXX设置进来
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybase");
        dataSource.setUsername("root");
        dataSource.setPassword("123");

        //调用对象的方法getConnection
        try {
            Connection con = dataSource.getConnection();
            System.out.println(con);
        }catch (SQLException ex) {
//            ex.printStackTrace();
            throw new RuntimeException("数据库连接失败");
        }

    }
}
