package cn.learn.basic.Demo13JDBC;
/*
    Java����ʵ���û���¼���û��������룬���ݿ���
        ��ʾע�빥��
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo03JDBC {
    public static void main(String[] args) throws Exception{
        //1.ע������
        Class.forName("com.mysql.jdbc.Driver");
        //2.��ȡ���Ӷ���
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "123";
        Connection con = DriverManager.getConnection(url, username, password);

        Statement stat = con.createStatement();

        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        String pass = sc.nextLine();
        //1' or '1=1 ���������Ϊ  x or true��ֱ�ӵ�¼�ɹ�
        //ִ��SQL��䣬���ݱ���ѯ�û��������룬������ڣ���¼�ɹ��������ڵ�¼ʧ��
        String sql = "SELECT * FROM users WHERE username='" + user + "' AND PASSWORD='"+ pass +"'";
        System.out.println(sql);
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("username") + " " + rs.getString("password"));
        }

        rs.close();
        stat.close();
        con.close();
    }
}
