package cn.learn.basic.Demo32Multi;

public class Demo04Main {

    public static void main(String[] args) {
        //���ȴ���һ���ʼǱ�����
        Computer computer = new Computer();
        computer.powerOn();

        //׼��һ����꣬������ʹ��
        //������ת��
        USB usb = new Mouse();//��̬д��
        //������USB���ͣ������ô��ݽ�ȥ�ľ���USB���
        computer.usbDevice(usb);
        //����һ������
        Keyboard keyboard = new Keyboard();
        //������������USB���ͣ����ݽ�ȥ����ʵ�������
        computer.usbDevice(keyboard);//��ȷд����Ҳ����������ת��
//        computer.usbDevice(new Keyboard());//��ȷд����Ҳ����������ת��

        computer.powerOf();

        method(10.0);//��ȷд����double ---> double
        method(10);//��ȷд����int ---> double

    }

    public static void method(double num) {
        System.out.println(num);
    }

}
