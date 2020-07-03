package cn.learn.basic.Demo14Q;
/*
    ʹ��DBCPʵ�����ݿ�����ӳ�
    ���ӳ����ã��Զ�����
    �������������
    �������ݿ����ӳ��������ã��Զ���
*/

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class JDBCUtiles {
    //����BasicDataSource�����
    private static BasicDataSource dataSource = new BasicDataSource();

    //��̬����飬����BasicDataSource�����ֵ����ã��Զ���
    static {
        //���ݿ�������Ϣ�������
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybase");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        //�����ӳ��е������������ã���ѡ��
        dataSource.setInitialSize(10);//��ʼ����������
        dataSource.setMaxActive(8);//�����������
        dataSource.setMaxIdle(5);//��������
        dataSource.setMinIdle(1);//��С������
    }

    //���徲̬����������BasicDataSource��Ķ���
    public static DataSource getDataSource() {
        return dataSource;
    }
}
