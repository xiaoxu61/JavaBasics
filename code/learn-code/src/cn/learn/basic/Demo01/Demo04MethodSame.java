package cn.learn.basic.Demo01;
/*
* ����һ���������ж��������Ƿ�һ��
* */
public class Demo04MethodSame {
    public static void main(String[] args) {
        System.out.println(isSame(10, 20));

    }
    public static boolean isSame(int a, int b){
//        ��һ���жϷ���
    /*    boolean same;
 *//*       if(a == b){
            same = true;
        }else{
            same = false;
        }*//*
//        �ڶ����жϷ�����
        same = a == b ? true:false;*/
        //�����ַ���
        return a == b;

    }
}
