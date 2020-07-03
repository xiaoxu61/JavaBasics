package cn.learn.basic.Demo01;
/*
* 定义一个方法，判断两个数是否一样
* */
public class Demo04MethodSame {
    public static void main(String[] args) {
        System.out.println(isSame(10, 20));

    }
    public static boolean isSame(int a, int b){
//        第一种判断方法
    /*    boolean same;
 *//*       if(a == b){
            same = true;
        }else{
            same = false;
        }*//*
//        第二种判断方法：
        same = a == b ? true:false;*/
        //第三种方法
        return a == b;

    }
}
