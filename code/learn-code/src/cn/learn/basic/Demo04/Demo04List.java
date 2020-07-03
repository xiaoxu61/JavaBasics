package cn.learn.basic.Demo04;
/*
 List�ӿ���ϵ���̳�Collection�ӿ�
    �����ʵ����
    List�ӿ��ص㣺���������������ظ�Ԫ��
        ʵ���࣬ArrayList��LinkedList
    �ӿ��еĳ��󷽷�����һ���ַ����͸��෽��Collectionһ��
    ��Ҫ��עList�����з��������������Ĺ���

*/

import java.util.ArrayList;
import java.util.List;

public class Demo04List {
    public static void main(String[] args) {
        demo01();
        System.out.println("===========");
        demo02();
        System.out.println("===========");
        demo03();
    }
    /*
        E set(int index, E)
        �޸�ָ�������ϵ�Ԫ��
        ���ر��޸�֮ǰ��Ԫ��
    */
    private static void demo03() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Integer set = list.set(3, 5);
        System.out.println(list);
        System.out.println(set);

    }

    /*
        E remove(int index)
        �Ƴ�ָ�������ϵ�Ԫ��,������ɾ��ǰ��Ԫ��
    */
    private static void demo02() {
        List<String> list = new ArrayList<String>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");

        String remove = list.remove(0);
        System.out.println(list);
        System.out.println(remove);
    }

    /*
        add(int index, E)
        ��Ԫ�ز��뵽�б��������
        ���������Ĳ�����Ҫע���ֹԽ������
        java.lang.IndexOutOfBoundsException
    */
    private static void demo01() {
        List<String> list = new ArrayList<String>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");
        System.out.println(list);

        list.add(2, "itCast");
        System.out.println(list);
    }
}
