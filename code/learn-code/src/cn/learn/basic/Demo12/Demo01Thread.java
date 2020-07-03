package cn.learn.basic.Demo12;
/*
    创建和启动一个线程
        创建Thread子类对象
        子类对象调用方法start()
            让线程程序执行，JVM调用线程中的run
    每个线程，都有自己的名字
        运行方法main线程名字就是main，
        其他新建的线程也有名字，默认 Thread-0 Thread-1

        JVM开启主线程，运行方法main，主线程也是线程，是线程必然就是Thread类对象
        Thread类中，静态方法
            static Thread currentThread() 返回正在执行的线程对象
*/

public class Demo01Thread {
    public static void main(String[] args) throws InterruptedException {
        subThread st = new subThread();
        st.setName("旺财");
        st.start();
        Thread.sleep(2000);
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        for (int i = 0; i < 50; i++) {
            System.out.println("main..." + i);
        }
        new SleepThread().start();
    }
}
