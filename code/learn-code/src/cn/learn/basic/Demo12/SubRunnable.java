package cn.learn.basic.Demo12;
/*
    ʵ���̳߳ɹ�����һ����ʽ���ӿ�ʵ��
    ʵ�ֽӿ�Runnable
*/

public class SubRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("run..." + i);
        }
    }
}
