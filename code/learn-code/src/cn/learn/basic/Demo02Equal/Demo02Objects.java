package cn.learn.basic.Demo02Equal;

import java.util.Objects;

public class Demo02Objects {
    public static void main(String[] args) {
        String s1 = null;
        String s2 = "abc";
//        boolean b = s1.equals(s2);//NullPointerException �ǲ��ܵ��÷����ģ����׳���ָ���쳣
//        System.out.println(b);
        /*
        Objects���equal������������������бȽϣ���ֹ��ָ���쳣
        public static boolean equals(Object a, Object b) {
            return (a == b) || (a != null && a.equals(b));
        */
        boolean b1 = Objects.equals(s1, s2);
        System.out.println(b1);
    }
}
