package cn.learn.GOF.kuangjia.factory.simple;
/*
����ģʽ�ĺ��ı��ʣ�
    ʵ��������ʹ��new���ù����������
    ��ѡ��ʵ���࣬��������ͳһ����Ϳ��ƣ��Ӷ��������߸����ǵ�ʵ�������
*/

public class Consumer {
    public static void main(String[] args) {
       /* //1���ӿڣ����е�ʵ����
        Car car = new WuLing();
        Car car1 = new Tesla();*/
        //2��ʹ�ù�������
        Car car = CarFactory.getCar("����");
        Car car1 = CarFactory.getCar("Tesla");

        car.name();
        car1.name();
    }
}
