package cn.learn.basic.Demo12;

public class Demo {

    public static void main(String[] args) {
        function();
        System.out.println(Math.abs(-9));
    }

    private static void function() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
    }
}
