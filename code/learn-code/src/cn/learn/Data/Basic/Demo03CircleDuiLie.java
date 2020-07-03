package cn.learn.Data.Basic;
/*
    ��ʵ�������Ŷӣ�ȡ�ŽкŵĹ���

*/

import java.util.Scanner;

public class Demo03CircleDuiLie {
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

class arrayLoopQeue {
    private int maxSize;//���������
    private int front;//ָ�������ͷ,���еĵ�һ��Ԫ��
    private int rear;//ָ����������һ��λ�õĺ�һ��λ��
    private int[] arr;//�����������ݣ�ģ�����

    //���ö��д�С
    public arrayLoopQeue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //�ж������Ƿ���
    public boolean isFull() {
        return (rear+1)%maxSize == front;
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
        arr[rear] = n;
        //��rear���ƣ����뿼��ȡģ
        rear = (rear + 1)%maxSize;
    }

    //��ȡ����
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("����Ϊ��");
        }
        //������Ҫ������front��ָ����еĵ�һ��Ԫ��
        //�Ȱ�front��Ӧ��ֵ������һ����ʱ����
        //��front����
        //����ʱ����ı�������
        int value = arr[front];
        front = (front + 1)%maxSize;
        return value;
    }

    //�鿴ͷ����
    public void getFront() {
        if (isEmpty()) {
            throw new RuntimeException("����Ϊ��");
        }
        System.out.printf("arr[%d]=%d\n", front,arr[front]);
    }

    //��������
    public void getArr() {
        if (isEmpty()) {
            throw new RuntimeException("����Ϊ��");
        }
        //��front��ʼ�������������ٸ�Ԫ��

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize , arr[i%maxSize]);
        }

    }

    //�����ǰ���е���Ч����
    public int size() {
        return (rear - front + maxSize)%maxSize;
    }
}
