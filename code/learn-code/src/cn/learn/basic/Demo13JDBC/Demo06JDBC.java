package cn.learn.basic.Demo13JDBC;
/*
 ʹ��PreparedStatement�ӿ� ʵ�����ݱ�Ĳ�ѯ����
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo06JDBC {
    public static void main(String[] args) throws Exception{
        //1.ע������
        Class.forName("com.mysql.jdbc.Driver");
        //2.��ȡ���Ӷ���
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "123";
        Connection con = DriverManager.getConnection(url, username, password);

        String sql = "SELECT * FROM sort";
        PreparedStatement pst = con.prepareStatement(sql);

        //����pst����ķ�����ִ�в�ѯ��䣬Select
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("sid") + "  " + rs.getString("sname")
                    + "  " + rs.getString("sprice") + "  " + rs.getString("sdesc"));
        }

        rs.close();
        pst.close();
        con.close();
    }
}
