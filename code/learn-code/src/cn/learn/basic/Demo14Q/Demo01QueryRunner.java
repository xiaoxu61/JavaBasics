package cn.learn.basic.Demo14Q;
/*
    使用QueryRunner类，实现对数据表的
    insert delete update
    调用方法QueryRunner类的方法update(Connection con, String sql, Object...param)
    Object...param 可变参数，Object类型，SQL语句会出现？占位符
    数据库连接对象，自定义的工具类传递
*/

import cn.learn.basic.Demo13JDBC.jdbcutil.JDBCUtilsConfig;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

public class Demo01QueryRunner {
    private static Connection con = JDBCUtilsConfig.getConnection();

    public static void main(String[] args) throws Exception{
//        insert();
//        update();
        delete();
    }
    public static void delete() throws Exception{
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        //写删除的SQL语句
        String sql = "DELETE FROM sort WHERE sid=?";
        int row = qr.update(con, sql, 9);
        System.out.println(row);
        /*
            判断insert，update，delete执行是否成功
            对返回值row判断
            if(row>0) 执行成功
        */
        DbUtils.closeQuietly(con);
    }
    /*
    * 定义方法，使用QueryRunner类的方法update将数据表的数据修改
    * */
    public static void update() throws Exception {
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        //写修改数据的SQL语句
        String sql = "UPDATE sort SET sname=?,sprice=?,sdesc=? WHERE sid=?";
        //定义Object数组，存储？中的参数
        Object[] params = {"花卉",100.88, "情人节玫瑰", 4};
        //调用QueryRunner方法update
        int row = qr.update(con, sql, params);
        System.out.println(row);
        DbUtils.closeQuietly(con);
    }

    /*
        定义方法，使用QueryRunner类的方法update想数据表中添加数据
    */
    public static void insert() throws Exception{
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        String sql = "INSERT INTO sort (sname, sprice, sdesc) VALUE(?,?,?)";
        //将三个？占位符的实际参数，写在数组中
        Object[] param = {"体育用品", 289.32, "购买体育用品"};
        //调用QueryRunner类的方法，update执行SQL语句
        int row = qr.update(con, sql, param);
        System.out.println(row);
        DbUtils.closeQuietly(con);

    }
}
