package cn.learn.basic.Demo12;
/*
    ���̲߳�������ͬһ��������Դ
    3���̣߳���ͬһ����Դ������
*/

public class Demo07Thread {
    public static void main(String[] args) {
        //����Runnable�ӿ�ʵ�ֶ���
        Pickets p = new Pickets();

        //��������Thread����󣬴���Runnable�ӿ�ʵ����
        Thread t0 = new Thread(p);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);

        t0.start();t1.start();t2.start();

    }
}
