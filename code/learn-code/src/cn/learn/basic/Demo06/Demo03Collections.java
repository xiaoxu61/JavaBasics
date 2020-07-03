package cn.learn.basic.Demo06;
/*
���ϲ����Ĺ�����
    Collections
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo03Collections {
    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
    }
    /*
        Collections.shuffle����
        ��List�����е�Ԫ�أ������������
    */
    private static void demo03() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(8);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
    }

    /*
        Collections.binarySearch��̬����
        ��List���Ͻ��ж�����������������������List���ϣ����ݱ����ҵ�Ԫ��
        �Ҳ������� -�����-1
    */
    private static void demo02() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(8);

        int index = Collections.binarySearch(list, 5);
        System.out.println(index);
    }

    /*
        Collections.sort ��̬����
        ����List���Ͻ�����������
    */
    private static void demo01() {
        //����List����
        List<String> list = new ArrayList<String>();
        list.add("ewdf");
        list.add("dqwbg");
        list.add("bc");
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
    }
}
