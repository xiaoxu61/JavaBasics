package cn.learn.basic.Demo12;
/*
    实现线程程序的第三个方式，事项Callable接口方式
    实现步骤
        1、工厂类Executers静态方法newFixedThreadPool方法创建线程池对象
        2、线程池对象ExecutorService接口实现类，调用方法submit提交线程任务
        3、submit(Callable c)
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo05ThreadPool {
    public static void main(String[] args) throws Exception{
        ExecutorService es = Executors.newFixedThreadPool(2);
        //提交线程任务的方法submit方法返回Future接口的实现类
        Future<String> ft = es.submit(new ThreadPoolCallable());
        System.out.println(ft.get());
    }
}
