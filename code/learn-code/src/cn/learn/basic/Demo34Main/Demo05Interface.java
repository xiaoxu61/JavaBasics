package cn.learn.basic.Demo34Main;


import java.util.ArrayList;
import java.util.List;

public class Demo05Interface {

    public static void main(String[] args) {
        //����ǽӿ����ƣ��ұ���ʵ�������ƣ�����Ƕ�̬д��
        List<String> list = new ArrayList<>();

        List<String> result  = addName(list);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static List<String> addName(List<String> list)  {
        list.add("�����Ȱ�");
        list.add("������");
        list.add("����");
        list.add("��lili");
        return list;
    }

}
