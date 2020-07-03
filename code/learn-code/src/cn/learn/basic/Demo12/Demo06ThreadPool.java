package cn.learn.basic.Demo12;
/*
    使用多线程技术，求和
    两个线程，一个线程计算1加到100，另一个线程计算1加到200的和
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
