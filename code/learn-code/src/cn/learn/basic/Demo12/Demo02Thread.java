package cn.learn.basic.Demo12;
/*
    ʵ�ֽӿڷ�ʽ���߳�
        ����Thread����󣬹��췽���д���Runnable�ӿ�ʵ����
        ����Thread�෽��start()
*/

public class Demo02Thread {
    public static void main(String[] args) {
        SubRunnable sr = new SubRunnable();
        Thread t = new Thread(sr);
        t.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("main..." + i);
        }
    }
}
