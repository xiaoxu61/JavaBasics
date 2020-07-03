package cn.learn.basic.Demo13JDBC;
/*
    ʹ��PreparedStatement�ӿڣ�ʵ�����ݱ�ĸ��²���
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Demo05JDBC {
    public static void main(String[] args) throws Exception{
        //1.ע������
        Class.forName("com.mysql.jdbc.Driver");
        //2.��ȡ���Ӷ���
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "123";
        Connection con = DriverManager.getConnection(url, username, password);

        //ƴд�޸ĵ�SQL��䣬���ã�ռλ
        String sql = "UPDATE sort SET sname=?, sprice=? WHERE sid=?";
        //�������ݿ�����Ӷ���con����preparedStatement��ȡSQL����Ԥ�������
        PreparedStatement pst = con.prepareStatement(sql);
        //����pst�ķ���setXXX ? ռλ
        pst.setObject(1, "��������");
        pst.setObject(2, 49988);
        pst.setObject(3, 7);
        //����pst����ִ��SQL���
        pst.executeUpdate();

        pst.close();
        con.close();
    }
}
