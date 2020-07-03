package cn.learn.basic.Demo14Q;
/*
    ����д�õĹ�����
    �ṩ����һ��DataSource�ӿڵ�����Դ
    QueryRunner�๹�췽��������DataSource�ӿڵ�ʵ����
    ���棬���÷���update��query�����贫������Connection���Ӷ���
*/

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.SQLException;
import java.util.List;

public class Demo04QueryRunner {
    public static void main(String[] args) {
//        insert();
        select();
    }
    //��������������ʵ�����ݱ����ӣ����ݱ��ѯ
    //QueryRunner�����д�����Աλ��
    private static QueryRunner qr = new QueryRunner(JDBCUtiles.getDataSource());

    //���ݱ��ѯ
    public static void select() {
        String sql = "SELECT * FROM sort";
        try {


            List<Object[]> lis = qr.query(sql, new ArrayListHandler());
            for (Object[] objs : lis) {
                for (Object obj : objs) {
                    System.out.print(obj + "\t");
                }
                System.out.println();
            }
        }catch (SQLException ex){}
    }
    //���ݱ��������
    public static void insert() {
        String sql = "INSERT INTO sort (sname, sprice, sdesc) VALUES(?,?,?)";
        Object[] param = {"ˮ��",100.12,"�ո����еĺ���"};
        try {
            int row = qr.update(sql, param);
            System.out.println(row);
        }catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("�������ʧ��");
        }

    }
}
