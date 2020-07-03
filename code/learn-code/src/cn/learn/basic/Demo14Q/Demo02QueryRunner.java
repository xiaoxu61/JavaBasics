package cn.learn.basic.Demo14Q;
/*
    QueryRunner ���ݲ�ѯ����
       ����QueryRunner�෽��query(Connection con, String sql, ResultSetHandler r, Object...param)
       ResultSetHandler r ������Ĵ���ʽ������ResultSetHandler�ӿ�ʵ����
       Object...param SQL����еģ�ռλ��

       ע�⣺
        query��������ֵ�����ص���T  ���ͣ����巵��ֵ���ͣ�������������ʽ�仯
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
        ������ڰ��֣�MapListHandler
        �������ÿһ�д洢��Map���ϣ�����������ֵ������
        Map���Ϲ��࣬�洢��List����
    */
    public static void mapListHandler() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sort";
        //���÷���query�����ݽ����ʵ����MapListHandler
        //����ֵList���ϣ��洢����Map����
        List<Map<String, Object>> maps = qr.query(con, sql, new MapListHandler());
        for (Map<String,Object> map : maps) {
            for (String key : map.keySet()) {
                System.out.print(key + " " + map.get(key) +"  ");
            }
            System.out.println();
        }
    }
    /*
        ������ĵ����ַ�����MapHandler
        ���������һ�����ݣ���װ��Map������
        Map<��,ֵ>  ��������  ֵ�����е�����
    */
    public static void mapHandler() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sort";
        //���÷���query�����ݽ����ʵ����MapHandler
        //����ֵ��Map���ϣ�Map�ӿڵ�ʵ���࣬����
        Map<String, Object> map = qr.query(con, sql, new MapHandler());
        //����Map����
        for (String key : map.keySet()) {
            System.out.println(key +"   " + map.get(key));
        }
    }
    /*
        ����������ַ�����ScalarHandler
        ���ڲ�ѯ��ֻ��һ�����
    */
    public static void scalarHandler() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT COUNT(*) FROM sort";
        //���÷���query�����ݽ��������ʵ����ScalarHandler
        Long count = qr.query(con, sql, new ScalarHandler<Long>());
        System.out.println(count);
    }
    /*
        ����������ַ�������ColumnListHandler
        �������ָ���е����ݣ��洢��List����
        List<Object> ÿ�����������Ͳ�ͬ
    */
    public static void columnListHandler() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sort";
        //���÷���query�����ݽ����ʵ����ColumnListHandler
        //ʵ���๹�췽���У�ʹ���ַ���������
        List<Object> lis = qr.query(con, sql, new ColumnListHandler<>("sname"));
        for (Object obj : lis) {
            System.out.println(obj);
        }
    }
    /*
        ����������ַ�������,BeanListHandler
        �����ݽ����ÿһ�����ݣ���װ��JavaBean����
        ���JavaBean�����װ��List������
    */
    public static void beanListHandler() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sort";
        //���÷������ݽ������ʵ����BeanListHandler
        //BeanListHandler(Class<T> type)
        List<Sort> lis = qr.query(con, sql, new BeanListHandler<Sort>(Sort.class));
        for(Sort s : lis) {
            System.out.println(s);
        }
    }
    /*
        ����������ַ�������, BeanHandler
        ��������ĵ�һ�����ݣ���װ��JavaBean����
        ע�⣺����װ�����ݵ�JavaBean����sort������пղ�������
    */
    public static void beanHandler() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sort";
        //���÷��������ݽ������ʵ���࣬BeanHandler
        //BeanHandler(Class<T> type)
        Sort s = qr.query(con, sql, new BeanHandler<Sort>(Sort.class));
        System.out.println(s);
    }
    /*
        ������ڶ��ַ�������ArrayListHandler
        ���������ÿһ�У���װ�����������У����ֺܶ��������
        ��������洢��List����
    */
    public static void arrayListHandler() throws Exception{
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sort";

        //����query���������������Ĳ����ϣ�����ʵ��ArrayListHandler
        //��������ֵ ÿ����һ����������
        List<Object[]> list = qr.query(con, sql, new ArrayListHandler());
        System.out.println(list);
        //���ϵı���
        for (Object[] objs : list) {
            for (Object obj : objs) {
                System.out.print(obj + "\t");
            }
            System.out.println();
        }
    }
    /*
        �������һ�ִ�������ArrayHandler
        ��������ĵ�һ�д洢������������ Object[]
    */
    public static void arrayHandler() throws Exception{
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sort WHERE sid=9";
        //���÷���queryִ�в�ѯ���������Ӷ���SQL��䣬���������ʽ��ʵ����
        Object[] result = qr.query(con, sql, new ArrayHandler());
        for (Object o : result) {
            System.out.println(o);
        }

    }
}
