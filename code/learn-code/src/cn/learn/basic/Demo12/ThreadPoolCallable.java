package cn.learn.basic.Demo12;
/*
    接口的实现类，作为线程提交任务出现
    使用方法返回值
*/

import java.util.concurrent.Callable;

public class ThreadPoolCallable implements Callable<String> {
    @Override
    public String call() {
        return "abc";
    }
}
