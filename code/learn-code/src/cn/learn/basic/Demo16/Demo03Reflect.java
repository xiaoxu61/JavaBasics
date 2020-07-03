package cn.learn.basic.Demo16;
/*
    �����ȡ˽�еĹ��췽������
    ���Ƽ����ƻ��˳���ķ�װ�ԣ���ȫ��
    ��������
*/

import java.lang.reflect.Constructor;

public class Demo03Reflect {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("cn.learn.basic.Demo16.Person");
        //Constructor[] getDeclaredConstructors() ��ȡ���еĹ��췽��������˽�е�
        /*Constructor[] cons = c.getDeclaredConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }*/

        //Constructor getDeclaredConstructor(Class...c) ��ȡ��ָ�������б�Ĺ��췽��
        Constructor con = c.getDeclaredConstructor(int.class, String.class);

        //Constructor �࣬����AccessibleObject�����巽��setAccessible(bolean b)
        con.setAccessible(true);

        Object obj = con.newInstance(18, "lisi");
        System.out.println(obj);
    }
}
