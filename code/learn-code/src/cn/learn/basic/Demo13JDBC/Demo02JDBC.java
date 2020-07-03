package cn.learn.basic.Demo13JDBC;
/*
    JDBC��������ѯ���ݱ���ȡ�����
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo02JDBC {
    public static void main(String[] args) throws Exception{
        //1.ע������
        Class.forName("com.mysql.jdbc.Driver");
        //2.��ȡ���Ӷ���
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url, username, password);
        //3.��ȡִ��SQL ������
        Statement state = con.createStatement();
        //ƴд��ѯ��SQL
        String sql = "SELECT * FROM sort";
        //4.����ִ���߶��󷽷���ִ��SQL����ȡ�����
        //ResultSet executeQuery(String sql) ִ��SQL����е�select��ѯ
        //����ֵResultSet�ӿڵ�ʵ�������ʵ������mysql������
        ResultSet rs = state.executeQuery(sql);
        //���������
        //ResultSet�ӿڷ��� boolean next() ����true���н����������falseû�н����
        while (rs.next()) {
            //��ȡÿ�е����ݣ�ʹ��ResultSet�ӿڵķ���getXX
            System.out.println(rs.getInt("sid") + "    " + rs.getString("sname")
                        +"   "+ rs.getDouble("sprice") + "    " + rs.getString("sdesc"));
        }
        System.out.println(rs);

        rs.close();
        state.close();
        con.close();
    }
}
