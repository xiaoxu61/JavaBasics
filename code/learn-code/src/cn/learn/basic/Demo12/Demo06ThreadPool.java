package cn.learn.basic.Demo12;
/*
    ʹ�ö��̼߳��������
    �����̣߳�һ���̼߳���1�ӵ�100����һ���̼߳���1�ӵ�200�ĺ�
*/

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo06ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = es.submit(new GetSunmCallable(100));

        Future<Integer> f2 = es.submit(new GetSunmCallable(200));

        System.out.println(f1.get());
        System.out.println(f2.get());

        es.shutdown();
    }
}
