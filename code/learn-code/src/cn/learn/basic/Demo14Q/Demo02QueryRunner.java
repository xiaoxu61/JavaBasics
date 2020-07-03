package cn.learn.basic.Demo14Q;
/*
    QueryRunner 数据查询操作
       调用QueryRunner类方法query(Connection con, String sql, ResultSetHandler r, Object...param)
       ResultSetHandler r 结果集的处理方式，传递ResultSetHandler接口实现类
       Object...param SQL语句中的？占位符

       注意：
        query方法返回值，返回的是T  泛型，具体返回值类型，跟随结果集处理方式变化
*/

import cn.learn.basic.Demo13JDBC.Sort;
import cn.learn.basic.Demo13JDBC.jdbcutil.JDBCUtilsConfig;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Demo02QueryRunner {
    private static Connection con = JDBCUtilsConfig.getConnection();

    public static void main(String[] args) throws Exception{
//        arrayHandler();
//        arrayListHandler();
//        beanHandler();
//        beanListHandler();
//        columnListHandler();
//        scalarHandler();
//        mapHandler();
        mapListHandler();
    }
    /*
        结果集第八种，MapListHandler
        将结果集每一行存储到Map集合，键：列名。值：数据
        Map集合过多，存储到List集合
    */
    public static void mapListHandler() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sort";
        //调用方法query，传递结果集实现类MapListHandler
        //返回值List集合，存储的是Map集合
        List<Map<String, Object>> maps = qr.query(con, sql, new MapListHandler());
        for (Map<String,Object> map : maps) {
            for (String key : map.keySet()) {
                System.out.print(key + " " + map.get(key) +"  ");
            }
            System.out.println();
        }
    }
    /*
        结果集的第七种方法，MapHandler
        将结果集第一行数据，封装到Map集合中
        Map<键,值>  键：列名  值：这列的数据
    */
    public static void mapHandler() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sort";
        //调用方法query，传递结果集实现类MapHandler
        //返回值：Map集合，Map接口的实现类，泛型
        Map<String, Object> map = qr.query(con, sql, new MapHandler());
        //遍历Map集合
        for (String key : map.keySet()) {
            System.out.println(key +"   " + map.get(key));
        }
    }
    /*
        结果集第六种方法，ScalarHandler
        对于查询后，只有一个结果
    */
    public static void scalarHandler() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT COUNT(*) FROM sort";
        //调用方法query，传递结果集处理实现类ScalarHandler
        Long count = qr.query(con, sql, new ScalarHandler<Long>());
        System.out.println(count);
    }
    /*
        结果集第五种方法处理，ColumnListHandler
        结果集，指定列的数据，存储到List集合
        List<Object> 每个列数据类型不同
    */
    public static void columnListHandler() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sort";
        //调用方法query，传递结果集实现类ColumnListHandler
        //实现类构造方法中，使用字符串的列名
        List<Object> lis = qr.query(con, sql, new ColumnListHandler<>("sname"));
        for (Object obj : lis) {
            System.out.println(obj);
        }
    }
    /*
        结果集第四种方法处理,BeanListHandler
        将数据结果的每一行数据，封装成JavaBean对象
        多个JavaBean对象封装到List集合中
    */
    public static void beanListHandler() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sort";
        //调用方法传递结果集的实现类BeanListHandler
        //BeanListHandler(Class<T> type)
        List<Sort> lis = qr.query(con, sql, new BeanListHandler<Sort>(Sort.class));
        for(Sort s : lis) {
            System.out.println(s);
        }
    }
    /*
        结果集第三种方法处理, BeanHandler
        将结果集的第一行数据，封装成JavaBean对象
        注意：被封装成数据到JavaBean对象，sort类必须有空参数构造
    */
    public static void beanHandler() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sort";
        //调用方法，传递结果集的实现类，BeanHandler
        //BeanHandler(Class<T> type)
        Sort s = qr.query(con, sql, new BeanHandler<Sort>(Sort.class));
        System.out.println(s);
    }
    /*
        结果集第二种方法处理，ArrayListHandler
        将结果集的每一行，封装到对象数据中，出现很多对象数组
        对象数组存储到List集合
    */
    public static void arrayListHandler() throws Exception{
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sort";

        //调用query方法，结果集处理的参数上，传递实现ArrayListHandler
        //方法返回值 每行是一个对象数组
        List<Object[]> list = qr.query(con, sql, new ArrayListHandler());
        System.out.println(list);
        //集合的遍历
        for (Object[] objs : list) {
            for (Object obj : objs) {
                System.out.print(obj + "\t");
            }
            System.out.println();
        }
    }
    /*
        结果集第一种处理方法，ArrayHandler
        将结果集的第一行存储到对象数组中 Object[]
    */
    public static void arrayHandler() throws Exception{
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sort WHERE sid=9";
        //调用方法query执行查询，传递连接对象，SQL语句，结果集处理方式的实现类
        Object[] result = qr.query(con, sql, new ArrayHandler());
        for (Object o : result) {
            System.out.println(o);
        }

    }
}
