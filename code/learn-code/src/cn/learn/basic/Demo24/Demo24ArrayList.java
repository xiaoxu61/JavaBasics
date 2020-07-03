package cn.learn.basic.Demo24;
/*
���鳤�Ȳ����Է����ı�
����ArrayList���ϳ����ǿ�������仯��

��ArrayList��˵����һ��������<E>����ָ����
���ͣ�װ�ڼ����е�����Ԫ�أ�ȫ������ͳһ������
ע�⣺����ֻ���������ͣ������ǻ�������
      ����ArrayList��˵��ֱ�Ӵ�ӡ�õ��Ĳ��ǵ�ֵַ����������
      ��������ǿգ��õ����ǿյ�������[]

ArrayList���еĳ��÷�����
    public boolean add <E e>���򼯺ϵ������Ԫ�أ����������ͺͷ���һ��
    public E get(int index)���Ӽ��ϵ��л�ȡԪ�أ�������������ţ�����ֵ���Ƕ�Ӧλ�õ�Ԫ��
    public int size()����ȡ���ϵĳߴ糤�ȣ�����ֵ�Ǽ����е�Ԫ�ظ���
    public E remove(int index)���Ӽ��ϵ���ɾ��Ԫ�أ�������������ţ�����ֵ���Ǳ�ɾ������Ԫ��
*/

import java.util.ArrayList;

public class Demo24ArrayList {
    public static void main(String[] args) {
        //������һ��ArrayList����������list������װ��ȫ����String�ַ������͵�����
        //��ע����JDK 1.7+��ʼ���Ҳ�������ڿ��Բ�д���ݣ����Ǽ����ű�����Ҫд��
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);

        //�򼯺������һЩ���ݣ���Ҫ�õ�add����
        list.add("�������");
        list.add("���������");
        list.add("�����������");
        System.out.println(list);

        boolean success = list.add("�������");
        System.out.println(list);
        System.out.println("����Ƿ�ɹ���" + success);

        //�Ӽ����л�ȡԪ�أ�get ����ֵ��0��ʼ
        String name = list.get(2);
        System.out.println("�ڶ�������λ�ã�" + name);

        //�Ӽ�����ɾ��Ԫ�أ�remove ����ֵ��0��ʼ
        String whoRemove = list.remove(3);
        System.out.println("��ɾ�����ǣ�" + whoRemove);
        System.out.println(list);

        //��ȡ���ϵĳ��ȳߴ磬Ҳ���Ǽ��ϵĸ���
        int size = list.size();
        System.out.println("�������ж��ٸ�Ԫ��:" + size);
        System.out.println("============================");
        //��������
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
