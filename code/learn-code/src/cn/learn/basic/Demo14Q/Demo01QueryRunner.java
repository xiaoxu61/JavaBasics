package cn.learn.basic.Demo14Q;
/*
    ʹ��QueryRunner�࣬ʵ�ֶ����ݱ��
    insert delete update
    ���÷���QueryRunner��ķ���update(Connection con, String sql, Object...param)
    Object...param �ɱ������Object���ͣ�SQL������֣�ռλ��
    ���ݿ����Ӷ����Զ���Ĺ����ഫ��
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
        //����QueryRunner�����
        QueryRunner qr = new QueryRunner();
        //дɾ����SQL���
        String sql = "DELETE FROM sort WHERE sid=?";
        int row = qr.update(con, sql, 9);
        System.out.println(row);
        /*
            �ж�insert��update��deleteִ���Ƿ�ɹ�
            �Է���ֵrow�ж�
            if(row>0) ִ�гɹ�
        */
        DbUtils.closeQuietly(con);
    }
    /*
    * ���巽����ʹ��QueryRunner��ķ���update�����ݱ�������޸�
    * */
    public static void update() throws Exception {
        //����QueryRunner�����
        QueryRunner qr = new QueryRunner();
        //д�޸����ݵ�SQL���
        String sql = "UPDATE sort SET sname=?,sprice=?,sdesc=? WHERE sid=?";
        //����Object���飬�洢���еĲ���
        Object[] params = {"����",100.88, "���˽�õ��", 4};
        //����QueryRunner����update
        int row = qr.update(con, sql, params);
        System.out.println(row);
        DbUtils.closeQuietly(con);
    }

    /*
        ���巽����ʹ��QueryRunner��ķ���update�����ݱ����������
    */
    public static void insert() throws Exception{
        //����QueryRunner�����
        QueryRunner qr = new QueryRunner();
        String sql = "INSERT INTO sort (sname, sprice, sdesc) VALUE(?,?,?)";
        //��������ռλ����ʵ�ʲ�����д��������
        Object[] param = {"������Ʒ", 289.32, "����������Ʒ"};
        //����QueryRunner��ķ�����updateִ��SQL���
        int row = qr.update(con, sql, param);
        System.out.println(row);
        DbUtils.closeQuietly(con);

    }
}
