package cn.learn.basic.Demo16;
/*
    ͨ�����䣬��ȡ�в����Ĺ��췽��������
    ����getConstructor�����ݿ��Թ��췽������ڵĲ����б���
*/

import java.lang.reflect.Method;

public class Demo06Reflect {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("cn.learn.basic.Demo16.Person");
        Object obj = c.newInstance();

        Method method = c.getMethod("sleep", String.class, int.class, double.class);

        method.invoke(obj, "����", 100, 888.99);

    }
}
