package cn.learn.basic.Demo01;
/*
  ���������أ�Overload����������������ƹ���һ�������ǲ����б겻һ��
  ��������������������أ�
    1������������ͬ
    2���������Ͳ�ͬ
    3�������Ķ�����˳��ͬ
  ���������в��������޹�
    1��������������޹�
    2���뷽���ķ���ֵ�����޹�
*/

public class Demo06MethodOverload {
    public static void main(String[] args) {
        System.out.println(sum(1,5));
        System.out.println(sum(1,5,6));
        System.out.println(sum(1,5,6,1));

    }

    public static int sum(int a, int b){
        System.out.println("doubleSum");
        return a+b;
    }
    public static int sum(int a, int b, int c){
        System.out.println("tripleSum");
        return a+b+c;
    }
    public static int sum(int a, int b, int c, int d){
        System.out.println("tetradSum");
        return a+b+c+d;
    }


}
