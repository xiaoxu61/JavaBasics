package cn.learn.basic.Demo14Q;
/*
    使用DBCP实现数据库的连接池
    连接池配置，自定义类
    最基本四项完整
    对于数据库连接池其他配置，自定义
*/

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class JDBCUtiles {
    //创建BasicDataSource类对象
    private static BasicDataSource dataSource = new BasicDataSource();

    //静态代码块，对象BasicDataSource对象种的配置，自定义
    static {
        //数据库连接信息，必须的
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybase");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        //对连接池中的连接数量配置，可选的
        dataSource.setInitialSize(10);//初始化的连接数
        dataSource.setMaxActive(8);//最大连接数量
        dataSource.setMaxIdle(5);//最大空闲数
        dataSource.setMinIdle(1);//最小空闲数
    }

    //定义静态方法，返回BasicDataSource类的对象
    public static DataSource getDataSource() {
        return dataSource;
    }
}
