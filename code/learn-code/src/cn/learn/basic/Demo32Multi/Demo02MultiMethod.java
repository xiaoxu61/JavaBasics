package cn.learn.basic.Demo32Multi;
/*
�ڶ�̬�Ĵ����У���Ա�����ķ��ʹ����ǣ�
    ��new����˭����������˭��û����������

�ھ������뿴��ߣ����п��ұ�

�Ա�һ�£�
��Ա���������뿴��ߣ����л������
��Ա���������뿴��ߣ����п��ұ�
*/

public class Demo02MultiMethod {

    public static void main(String[] args) {

        Fu obj = new Zi();//��̬
        obj.method();//���Ӷ��У���������
        obj.methodFu();

        //���뿴��ߣ������Fu��Fu����û��methodZi���������Ա��뱨��
//        obj.methodZi();//����д��

    }

}
