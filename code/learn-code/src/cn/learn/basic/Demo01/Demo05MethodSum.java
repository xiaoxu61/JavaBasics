package cn.learn.basic.Demo01;
/*
  ��ĿҪ��
       1������һ���������������1~100֮���������ֵ�ֵ
       2������һ��������������ӡָ��������HelloWorld
*/
public class Demo05MethodSum {
    public static void main(String[] args) {
        System.out.println(getSum());
        print(5);
    }


    public static int getSum(){
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
    public static void print(int a){
        for (int i = 1; i <= a; i++) {
            System.out.println("HelloWorld"+i);
        }
    }
}
