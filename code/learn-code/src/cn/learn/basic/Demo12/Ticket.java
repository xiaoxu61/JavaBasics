package cn.learn.basic.Demo12;
/*
    ����ͬ��������ʽ������̵߳İ�ȫ����
    �ô���������
    ���̹߳������ݣ���ͬ������ȡ��ͬһ��������
    �ڷ����������ϣ�����ͬ���ؼ���synchronized

    ͬ�������еĶ��������Ǳ���Ķ�������this
    ��������Ǿ�̬�ģ�ͬ�����������Ǳ����Լ�.class
    ��̬�����У�ͬ�������Ǳ�������.class����
*/

public class Ticket implements Runnable{
    //������۵�ƱԴ
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            payTicket();
        }
    }

    public synchronized void payTicket() {
        //��Ʊ���жϣ�����0�����Գ��ۣ�����--����
        //�̹߳������ݣ���֤��ȫ������ͬ�������
        //ͬ��������̰߳�ȫ�ˣ����������ٶ�����
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
