package cn.learn.basic.Demo04;
/*
    LinkedHashSet ��������Ĺ�ϣ��ʵ��
    �̳���HashSet

    LinkedHashSet �������ԣ�����˳�򣬴洢��ȡ����˳����ͬ
    �̲߳���ȫ�ļ��ϣ������ٶȿ�
*/

import java.util.LinkedHashSet;

public class Demo07LinkedHashSet {
    public static void main(String[] args) {
        demo01();
    }

    private static void demo01() {
        LinkedHashSet<Integer> link = new LinkedHashSet<>();
        link.add(12);
        link.add(13);
        link.add(14);
        link.add(15);
        System.out.println(link);
    }
}
