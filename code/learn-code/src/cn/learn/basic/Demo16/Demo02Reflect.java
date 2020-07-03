package cn.learn.basic.Demo16;
/*
    ͨ�������ȡclass�ļ��еĹ��췽�������й��췽��
    ���й��췽������������
        ��ȡclass�ļ�����
        ��class�ļ������У���ȡ��Ҫ�ĳ�Ա
*/

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo02Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = Class.forName("cn.learn.basic.Demo16.Person");
        //ʹ��class�ļ����󣬻�ȡ���еĹ��췽��
        //Constructor[] getConstructors() ��ȡclass�ļ������е����й����Ĺ��췽��
        /*Constructor[] cons = c.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }*/

        /*//��ȡָ���Ĺ��췽�����ղ����Ĺ��췽��
        Constructor con = c.getConstructor();
        System.out.println(con);
        //���пղ������췽����Constructor�෽�� newInstance() ���л�ȡ���Ĺ��췽��
        Object o = con.newInstance();
        System.out.println(o);*/

        //��ȡ����String��int�����Ĺ��췽��
        //Constructor<T> getConstructor(Class<?>...parameterTypes)
        //Class<?>...parameterTypes  ����Ҫ��ȡ�Ĺ��췽�����Ӧ�Ĳ����б�
        /*Constructor con = c.getConstructor(String.class, int.class);
        System.out.println(con);
        //���й��췽��
        // T newInstance(Object...initargs) ���й��췽���󣬴��ݵ�ʵ�ʲ���
        Object obj = con.newInstance("����", 20);
        System.out.println(obj);*/

        /*
            �����ȡ���췽�������У��п�ݵ�ķ�ʽ
            ǰ�᣺
                ��������࣬�����пղ������췽��
                ���췽��Ȩ�ޱ���public

            Class���ж���ķ�����T newInstance() ֱ�Ӵ�����������Ķ���ʵ��
        */
        Object obj = c.newInstance();
        System.out.println(obj);
    }
}
