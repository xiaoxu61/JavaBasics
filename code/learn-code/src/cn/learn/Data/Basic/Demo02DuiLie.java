package cn.learn.Data.Basic;
/*
    ��ʵ�������Ŷӣ�ȡ�ŽкŵĹ���

*/

import java.util.Scanner;

public class Demo02DuiLie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("��������г��ȣ�");
        int maxSize = sc.nextInt();
        arrayLoopQeue arrayLoopQeue = new arrayLoopQeue(maxSize);

        boolean loop = true;
        while (loop) {
            System.out.println("a �������:");
            System.out.println("g �õ����е�һλ��");
            System.out.println("f �鿴ͷ���ݣ�");
            System.out.println("b �������飺");
            System.out.println("e �Ƴ�����");
            char[] chars = sc.next().toCharArray();

            switch (chars[0]) {
                case 'a':
                    System.out.println("������һ������");
                    int i = sc.nextInt();
                    arrayLoopQeue.addQeue(i);
                    break;

                case 'g':
                    int queue = arrayLoopQeue.getQueue();
                    System.out.println("ȡ�����ǣ�" + queue);
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
    private int maxSize;//���������
    private int front;//�����ͷ
    private int rear;//�����β
    private int[] arr;//�����������ݣ�ģ�����

    //���ö��д�С
    public arrayQeue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //�ж������Ƿ���
    public boolean isFull() {
        return rear == maxSize-1;
    }

    //�ж������Ƿ��
    public boolean isEmpty() {
        return front == rear;
    }

    //�������
    public void addQeue(int n) {
        if (isFull()) {
            System.out.println("�������ˣ��������~");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //��ȡ����
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("����Ϊ��");
        }
        front++;
        return arr[front];
    }

    //�鿴ͷ����
    public void getFront() {
        if (isEmpty()) {
            throw new RuntimeException("����Ϊ��");
        }
        System.out.printf("arr[%d]=%d\n", front+1,arr[front+1]);
    }

    //��������
    public void getArr() {
        if (isEmpty()) {
            throw new RuntimeException("����Ϊ��");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i , arr[i]);
        }

    }
}
