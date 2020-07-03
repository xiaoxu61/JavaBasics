package cn.learn.basic.Demo16;

/*
    ����Person�ķ���������Student����������Worker����
    �಻���������Ҳ�����
    ͨ�������ļ�ʵ�ִ˹���
        ���е������ͷ������֣��Լ�ֵ�Ե���ʽ��д���ı���
        �����ĸ�����ȡ�����ļ�����

    ʵ�ֲ��裺
        1��׼�������ļ�����ֵ��
        2��IO����ȡ�����ļ�Reader
        3���ļ��еļ�ֵ�Դ洢��������Properties
        4�������ȡָ�����class�ļ�����
        5��class�ļ����󣬻�ȡָ���ķ���
        6�����з���
*/

import cn.learn.basic.Demo13JDBC.Demo08Properties;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo08Test {
    public static void main(String[] args) throws Exception{
        //IO��ȡ�����ļ�
        InputStream r = Demo08Properties.class.getClassLoader().getResourceAsStream("config.properties");
        //�������϶���
        Properties pro = new Properties();
        //���ü���load�����ݶ�����
        pro.load(r);
        r.close();
        //ͨ��������ȡֵ
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //�����ȡָ�����class�ļ�����
        Class c = Class.forName(className);
        Object obj = c.newInstance();
        //��ȡָ���ķ�����
        Method method = c.getMethod(methodName);
        method.invoke(obj);
    }
}
