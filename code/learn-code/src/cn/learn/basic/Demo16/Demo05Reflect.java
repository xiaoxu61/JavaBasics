package cn.learn.basic.Demo16;
/*
    �����ȡ��Ա����������
    public void eat(){}
*/

import java.lang.reflect.Method;

public class Demo05Reflect {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("cn.learn.basic.Demo16.Person");
        Object obj = c.newInstance();
        //��ȡclass�����еĳ�Ա����
        //Method[] getMethods() ��ȡ����class�ļ��е����й�����Ա�����������̳е�
        //Method����������Ա�ķ�������
        /*Method[] methods = c.getMethods();
        for(Method m : methods) {
            System.out.println(m);
        }*/
        //��ȡָ���ķ���eat����
        //Method getMethod(String methodName, Class...c)
        //methodName��ȡ�ķ����� c �����Ĳ����б�
        Method method = c.getMethod("eat");
        //ʹ��Method���еķ��������л�õķ���
        // Object invoke(Object obj, Object...o)
        method.invoke(obj);
    }
}
