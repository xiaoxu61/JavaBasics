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
                //判断标记，是false，等待
                if (!r.flag) {
                    try {
                        r.wait();
                    } catch (InterruptedException e) {}
                }
                System.out.println(r.name + "..." + r.sex);
                //将标记改为false，唤醒对方线程
                r.flag = false;
                r.notify();
            }
        }
    }
}
