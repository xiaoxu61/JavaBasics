package cn.learn.basic.Demo14Q;
/*
    ���ӳ�jar���У������һ����BasicDataSource
    ʵ��������Դ�Ĺ淶�ӿڣ�javax.sql.DataSource
*/

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo03DataSoruce {
    public static void main(String[] args) {
        //����DataSource�ӿڵ�ʵ�������
        //ʵ���࣬org.apache.commons.dbcp
        BasicDataSource dataSource = new BasicDataSource();
        //�������ݿ��4���������Ϣ��ͨ�����󷽷�setXXX���ý���
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybase");
        dataSource.setUsername("root");
        dataSource.setPassword("123");

        //���ö���ķ���getConnection
        try {
            Connection con = dataSource.getConnection();
            System.out.println(con);
        }catch (SQLException ex) {
//            ex.printStackTrace();
            throw new RuntimeException("���ݿ�����ʧ��");
        }

    }
}
