package cn.learn.basic.Demo13JDBC;
/*
    ����properties�����ļ�
    IO��ȡ�ļ�����ֵ�Դ洢������
    �Ӽ������Լ�ֵ�Է�ʽ��ȡ���ݿ��������Ϣ��������ݿ������
*/

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Demo08Properties {
    public static void main(String[] args) throws Exception{
        //ʹ����ļ�������
        InputStream in = Demo08Properties.class.getClassLoader().getResourceAsStream("database.properties");
        System.out.println(in);
        /*FileInputStream fis = new FileInputStream("database.properties");
        System.out.println(fis);*/
        Properties pro = new Properties();
        pro.load(in);
        //��ȡ�����еļ�ֵ��
        String driverClass = pro.getProperty("driverClass");
        String url = pro.getProperty("url");
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");
        Class.forName(driverClass);
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println(con);
    }
}
