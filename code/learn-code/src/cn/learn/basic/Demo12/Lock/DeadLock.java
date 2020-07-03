package cn.learn.basic.Demo12.Lock;

public class DeadLock implements Runnable{

    private int i = 0;
    @Override
    public void run() {
        while (true) {
            if (i%2 ==0) {
                //先进入A同步，再进入B同步
                synchronized (LockA.lockA) {
                    System.out.println("if....locka");
                    synchronized (LockB.lockB) {
                        System.out.println("if....lockb");
                    }
                }
            }else {
                //先进入B同步，再进入A同步
                synchronized (LockB.lockB) {
                    System.out.println("else....lockb");
                    synchronized (LockA.lockA) {
                        System.out.println("else....locka");
                    }
                }
            }
            i++;
        }
    }
}
