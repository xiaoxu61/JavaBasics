package cn.learn.basic.Demo13JDBC;

/*
    Java����ʵ���û���¼���û��������룬���ݿ���
        ��ֹע�빲��

        Statement�ӿ�ʵ���࣬����ִ��SQL��䣬���ؽ����
        ��һ���ӽӿ�PreparedStatement(SQLԤ����洢����θ�Ч��ִ��SQL)
        PreparedStatement��ʵ�������ݿ�������У���λ�ȡ�ӿڵ�ʵ����
        �˷�����Connection���ݿ����Ӷ���ķ���
        PreparedStatement preparedStatement(String sql)
*/

import java.sql.*;
import java.util.Scanner;

public class Demo04JDBC {
    public static void main(String[] args) throws Exception{
        //1.ע������
        Class.forName("com.mysql.jdbc.Driver");
        //2.��ȡ���Ӷ���
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "123";
        Connection con = DriverManager.getConnection(url, username, password);

        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        String pass = sc.nextLine();
        //1' or '1=1 ���������Ϊ  x or true��ֱ�ӵ�¼�ɹ�
        //ִ��SQL��䣬���ݱ���ѯ�û��������룬������ڣ���¼�ɹ��������ڵ�¼ʧ��
        String sql = "SELECT * FROM users WHERE username=? AND PASSWORD=?";
        //����Connection�ӿڵķ�����preparedStatement����ȡpreparedStatement�ӿڵ�ʵ����
        PreparedStatement pst = con.prepareStatement(sql);
        //����pst����ķ����������ʺ�ռλ���ϵĲ���
        pst.setObject(1, user);
        pst.setObject(2, pass);
        System.out.println(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("username") + " " + rs.getString("password"));
        }

        rs.close();
        pst.close();
        con.close();
    }
}

