package cn.learn.GOF.kuangjia.factory.method;
/*
����ģʽ�ĺ��ı��ʣ�
    ʵ��������ʹ��new���ù����������
    ��ѡ��ʵ���࣬��������ͳһ����Ϳ��ƣ��Ӷ��������߸����ǵ�ʵ�������
*/

public class Consumer {
    public static void main(String[] args) {
       Car car = new WuLingFactory().getCar();
       Car car1 = new TeslaFactory().getCar();
       Car car2 = new MoBaiFactory().getCar();

       car.name();
       car1.name();
       car2.name();
    }
    //�ṹ���Ӷ� simple
    //���븴�Ӷ� simple
    //��̸��Ӷ� simple
    //�����Ӷ� simple
    //�������ԭ�򣬹�������ģʽ
    //����ʵ��ҵ�񣺼򵥹���ģʽ
}
