package cn.learn.Data.Basic;
/*
    简单实现银行排队，取号叫号的功能

*/

import java.util.Scanner;

public class Demo02DuiLie {
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

class arrayQeue{
    private int maxSize;//数组的容量
    private int front;//数组的头
    private int rear;//数组的尾
    private int[] arr;//改数组存放数据，模拟队列

    //设置队列大小
    public arrayQeue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断数组是否满
    public boolean isFull() {
        return rear == maxSize-1;
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
        rear++;
        arr[rear] = n;
    }

    //获取数组
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    //查看头数据
    public void getFront() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        System.out.printf("arr[%d]=%d\n", front+1,arr[front+1]);
    }

    //遍历数组
    public void getArr() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i , arr[i]);
        }

    }
}
