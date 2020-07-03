package cn.learn.basic.Demo12.Lock;
/*
    ʹ��JDK 1.5�Ľӿ�Lock���滻ͬ������飬ʵ���̵߳İ�ȫ��
    Lock�ӿڷ�����
        lock()      ��ȡ��
        unlock()    �ͷ���

    ʵ����ReentrantLock
*/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable{
    //������۵�ƱԴ
    private int ticket = 100;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            //����Lock�ӿڷ�����lock��ȡ��
            lock.lock();
            //��Ʊ���жϣ�����0�����Գ��ۣ�����--����
            if (ticket > 0) {

                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "���۵�"+ (ticket--) +"��Ʊ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //�ͷ���
                    lock.unlock();
                }
            }

        }
    }
}
