package cn.learn.basic.Demo12;
/*
    开启输入和输出线程，实现赋值和打印
*/

public class Demo09Thread {
    public static void main(String[] args) {
        Resource r = new Resource();

        Input in = new Input(r);
        Output out = new Output(r);

        Thread tin = new Thread(in);
        Thread Tout = new Thread(out);

        tin.start();
        Tout.start();
    }
}
