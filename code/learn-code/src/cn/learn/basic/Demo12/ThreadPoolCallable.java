package cn.learn.basic.Demo12;
/*
    �ӿڵ�ʵ���࣬��Ϊ�߳��ύ�������
    ʹ�÷�������ֵ
*/

import java.util.concurrent.Callable;

public class ThreadPoolCallable implements Callable<String> {
    @Override
    public String call() {
        return "abc";
    }
}
