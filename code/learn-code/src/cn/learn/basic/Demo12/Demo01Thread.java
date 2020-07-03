package cn.learn.basic.Demo12;
/*
    ����������һ���߳�
        ����Thread�������
        ���������÷���start()
            ���̳߳���ִ�У�JVM�����߳��е�run
    ÿ���̣߳������Լ�������
        ���з���main�߳����־���main��
        �����½����߳�Ҳ�����֣�Ĭ�� Thread-0 Thread-1

        JVM�������̣߳����з���main�����߳�Ҳ���̣߳����̱߳�Ȼ����Thread�����
        Thread���У���̬����
            static Thread currentThread() ��������ִ�е��̶߳���
*/

public class Demo01Thread {
    public static void main(String[] args) throws InterruptedException {
        subThread st = new subThread();
        st.setName("����");
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
