package cn.learn.basic.Demo12;
/*
    实现线程成功的另一个方式，接口实现
    实现接口Runnable
*/

public class SubRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("run..." + i);
        }
    }
}
