package cn.learn.Data.Basic;
/*
    简单实现银行排队，取号叫号的功能

*/

import java.util.Scanner;

public class Demo03CircleDuiLie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入队列长度：");
        int maxSize = sc.nextInt();
        arrayLoopQeue arrayLoopQeue = new arrayLoopQeue(maxSize);

        boolean loop = true;
        while (loop) {
            System.out.println("a 添加数组:");
            System.out.println("g 拿到队列第一位：");
            System.out.println("f 查看头数据：");
            System.out.println("b 遍历数组：");
            System.out.println("e 推出程序：");
            char[] chars = sc.next().toCharArray();

            switch (chars[0]) {
                case 'a':
                    System.out.println("请输入一个数：");
                    int i = sc.nextInt();
                    arrayLoopQeue.addQeue(i);
                    break;

                case 'g':
                    int queue = arrayLoopQeue.getQueue();
                    System.out.println("取到的是：" + queue);
                    break;

                case 'f':
                    arrayLoopQeue.getFront();
                    break;

                case 'b':
                    arrayLoopQeue.getArr();
                    break;

                case 'e':
                    sc.close();
                    loop = false;
                    break;
            }
        }
    }
}

class arrayLoopQeue {
    private int maxSize;//数组的容量
    private int front;//指向数组的头,队列的第一个元素
    private int rear;//指向数组的最后一个位置的后一个位置
    private int[] arr;//改数组存放数据，模拟队列

    //设置队列大小
    public arrayLoopQeue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断数组是否满
    public boolean isFull() {
        return (rear+1)%maxSize == front;
    }

    //判断数组是否空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加数组
    public void addQeue(int n) {
        if (isFull()) {
            System.out.println("数组满了，不能添加~");
            return;
        }
        arr[rear] = n;
        //将rear后移，必须考虑取模
        rear = (rear + 1)%maxSize;
    }

    //获取数组
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        //这里需要分析除front是指向队列的第一个元素
        //先把front对应的值保留到一个临时变量
        //将front后移
        //将临时保存的变量返回
        int value = arr[front];
        front = (front + 1)%maxSize;
        return value;
    }

    //查看头数据
    public void getFront() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        System.out.printf("arr[%d]=%d\n", front,arr[front]);
    }

    //遍历数组
    public void getArr() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        //从front开始遍历，遍历多少个元素

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize , arr[i%maxSize]);
        }

    }

    //求出当前队列的有效数据
    public int size() {
        return (rear - front + maxSize)%maxSize;
    }
}
