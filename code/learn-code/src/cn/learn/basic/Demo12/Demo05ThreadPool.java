package cn.learn.basic.Demo12;
/*
    ʵ���̳߳���ĵ�������ʽ������Callable�ӿڷ�ʽ
    ʵ�ֲ���
        1��������Executers��̬����newFixedThreadPool���������̳߳ض���
        2���̳߳ض���ExecutorService�ӿ�ʵ���࣬���÷���submit�ύ�߳�����
        3��submit(Callable c)
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo05ThreadPool {
    public static void main(String[] args) throws Exception{
        ExecutorService es = Executors.newFixedThreadPool(2);
        //�ύ�߳�����ķ���submit��������Future�ӿڵ�ʵ����
        Future<String> ft = es.submit(new ThreadPoolCallable());
        System.out.println(ft.get());
    }
}
