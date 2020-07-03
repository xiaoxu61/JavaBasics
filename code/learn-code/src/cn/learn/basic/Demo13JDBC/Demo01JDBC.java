package cn.learn.basic.Demo13JDBC;
/*
JDBC�������ݿ�Ĳ���
1.	ע������.  ��֪JVMʹ�õ�����һ�����ݿ�����
2.	�������.  ʹ��JDBC�е��࣬��ɶ�MySQL���ݿ������
3.	������ִ��ƽ̨  ͨ�����Ӷ����ȡ��SQL����ִ���߶���
4.	ִ��sql���   ʹ��ִ���߶��������ݿ�ִ��SQL��䣬��ȡ�����ݿ��ִ�к�Ľ��
5.	������
6.	�ͷ���Դ.   ����һ��close()


*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //ע�����������似��������������뵽����
        //ʹ��java.sql.DriverManger��̬����registerDriver(Driver driver)
        //Driver��һ���ӿڣ��������ݣ�MySQL���������е�ʵ����
        //DriverManager.registerDriver(new Driver());
        //������Դ���룬ע��2����������

        Class.forName("com.mysql.jdbc.Driver");

        //������ݿ�����
        //static Connection getConnection(String url, String user, String password)
        //����ֵ��Connection�ӿڵ�ʵ���࣬��mysql��������
        //url�����ݿ����ӵ�ַ   jdbc://��������IP:�˿ں�//���ݿ�����
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url, username, password);

        //��ȡ���ִ��ƽ̨��ͨ�����ݿ����Ӷ��󣬻�ȡ��SQL����ִ���߶���
        //con������÷����� Statement createStatement() ��ȡStatement���󣬽�SQL��䷢�͵����ݿ�
        //����ֵStatement�ӿڵ�ʵ���������mysql��������
        Statement stat = con.createStatement();

        //ִ��sql���
        //ͨ��ִ���߶�����÷���ִ��SQL��䣬��ȡ���
        //int executeUpdate(String sql) ִ�����ݿ��е�SQL��䣬insert delete update
        int row = stat.executeUpdate
                ("INSERT INTO sort(sname,sprice,sdesc) VALUES('������Ʒ',50000,'����Ǽ�')");

        System.out.println(row);

        //�ͷ���Դ
        stat.close();
        con.close();
    }
}
