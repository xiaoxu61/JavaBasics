package cn.learn.basic.Demo12;

public class Output implements Runnable {
    private Resource r;

    public Output(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (r) {
                //�жϱ�ǣ���false���ȴ�
                if (!r.flag) {
                    try {
                        r.wait();
                    } catch (InterruptedException e) {}
                }
                System.out.println(r.name + "..." + r.sex);
                //����Ǹ�Ϊfalse�����ѶԷ��߳�
                r.flag = false;
                r.notify();
            }
        }
    }
}
