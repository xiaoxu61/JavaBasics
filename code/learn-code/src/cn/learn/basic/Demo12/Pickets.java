package cn.learn.basic.Demo12;
/*
    ͨ���߳����ߣ����ְ�ȫ����
    ������⣺Java����
    �ṩ������ͬ������
    ��ʽ��
        synchronized(�������){
            �߳�Ҫ�����Ĺ�������
        }
*/

public class Pickets implements Runnable {

    //������۵�ƱԴ
    private int ticket = 100;
    private Object obj  = new Object();
    @Override
    public void run() {
        while (true) {
            //��Ʊ���жϣ�����0�����Գ��ۣ�����--����
            //�̹߳������ݣ���֤��ȫ������ͬ�������
            synchronized (obj) {//ͬ��������̰߳�ȫ�ˣ����������ٶ�����
                if (ticket > 0) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "���۵�"+ (ticket--) +"��Ʊ");
                }
            }

        }
    }
}
