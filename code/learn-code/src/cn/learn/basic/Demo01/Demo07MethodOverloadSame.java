package cn.learn.basic.Demo01;
/*
 ��ĿҪ��
    �Ƚ����������Ƿ����
    �������ͷֱ�Ϊ����byte������long������int������short����
    ����main�����н��в���

*/

public class Demo07MethodOverloadSame {
    public static void main(String[] args) {

        System.out.println(isSame((short)10,(short)50));
        System.out.println(isSame(10,20));
        System.out.println(isSame((long)2, (long)5));
    }
    public static boolean isSame(byte a, byte b){
        System.out.println("����byte�����ķ���ִ��");
        boolean same;
        if(a == b){
            same = true;
        }else{
            same = false;
        }
        return same;
    }

    public static boolean isSame(short a, short b){
        System.out.println("����short�����ķ���ִ��");
        boolean same = a == b ? true:false;
        return same;
    }

    public static boolean isSame(int a, int b){
        System.out.println("����int�����ķ���ִ��");
        return a == b;
    }

    public static boolean isSame(long a, long b){
        System.out.println("����long�����ķ���ִ��");
        return a == b;
    }
}


