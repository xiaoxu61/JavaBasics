package cn.learn.basic.Demo32Multi;
/*
���뵱�����ֶ�̬�ԣ����о���һ�仰����������ָ����������
��ʽ��
�������� ������ = new ��������();
���ߣ�
�ӿ����� ������ = new ʵ��������();

���ʳ�Ա���������ַ�ʽ��
1��ֱ��ͨ���������Ʒ��ʳ�Ա���������Ⱥ������˭��������˭��û����������
2��ֱ��ͨ����Ա�������ʳ�Ա���������÷�������˭��������˭��û����������

*/

public class Demo01Multi {

    public static void main(String[] args) {

        //ʹ�ö�̬��д��
        //��ุ������ã�ָ�����Ҳ�����Ķ���
        Fu obj = new Zi();

        obj.method();
        obj.methodFu();
        System.out.println(obj.num);
        System.out.println("==============");

        obj.showNum();

    }

}
