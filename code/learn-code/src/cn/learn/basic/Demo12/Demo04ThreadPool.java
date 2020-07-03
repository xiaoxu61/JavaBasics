package cn.learn.basic.Demo12;
/*
    JDK 1.5�����ԣ�ʵ���̳߳س���
    ʹ�ù����� Executors �еľ�̬���������̶߳���ָ���̵߳ĸ���
    static ExecutorService newFixedThreadPool(int ����) �����̳߳ض���
    ���ص���ExecutorService�ӿڵ�ʵ����(�̳߳ض���)

    �ӿ�ʵ������󣬵��÷���submit(Runnable r) �ύ�߳�ִ������
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo04ThreadPool {
    public static void main(String[] args) {
        //���ù�����ľ�̬�����������̳߳ض���
        //�����̳߳ض����Ƿ��صĽӿ�
        ExecutorService es = Executors.newFixedThreadPool(2);
        //���ýӿ�ʵ�������ķ���submit�ύ�߳�����
        //��Runnable�ӿ�ʵ������󣬴���
        es.submit(new ThreadPoolRunnable());
        es.submit(new ThreadPoolRunnable());
        es.submit(new ThreadPoolRunnable());

        es.shutdown();//�����̳߳�
    }
}
