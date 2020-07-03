package cn.learn.basic.Demo03;
/*
���ڳ�����������
    ����longȡֵ��Χ��������װ��BigInteger���Ͷ���
*/

import java.math.BigDecimal;
import java.math.BigInteger;

public class Demo09BigInteger {
    public static void main(String[] args) {
        function_1();
        System.out.println("===============");
        function_2();

    }

    private static void function_2() {
        /*
            ��������δ֪
            ԭ��
                ������������У���ʾ����������ȷ���
            �������͵ĸ������ݣ��ṩ�߾��ȵĸ������㣬BigDecimal,������������������ͬ
        */
        System.out.println(0.09 + 0.01);
        System.out.println(1.0 - 0.32);
        System.out.println(1.015 * 100);
        System.out.println(1.301 / 100);

        BigDecimal b1 = new BigDecimal("0.09");
        BigDecimal b2 = new BigDecimal("0.01");
        //�ӷ�
        BigDecimal add = b1.add(b2);
        System.out.println(add);

         b1 = new BigDecimal("1");
         b2 = new BigDecimal("0.32");
        //����
        BigDecimal subtract = b1.subtract(b2);
        System.out.println(subtract);

        b1 = new BigDecimal("1.015");
        b2 = new BigDecimal("100");
        //�˷�
        BigDecimal multiply = b1.multiply(b2);
        System.out.println(multiply);

        b1 = new BigDecimal("1.301");
        b2 = new BigDecimal("100");
        //����
        //�г��������������������Ҫѡ����С��λ
        //�磺devide(BigDecimal divisor, int scale, int roundingMode)
        //int scale��������λС��
        //int roundingMode������ģʽ ����API�ĵ�
        //int roundingMode������ģʽ ����API�ĵ�
        //static int ROUND_UP ����+1
        //static int ROUND_HALF_UP >=0.5 ����+1
        //static int ROUND_HALF_DOWN >0.5 ����+1������ֱ����ȥ
        BigDecimal divide = b1.divide(b2, 2, BigDecimal.ROUND_UP);
        System.out.println(divide);
    }

    /*
        BigInteger��Ĺ��췽��
        �����ַ�����Ҫ�����ָ�ʽ��û�г�������
    */
    private static void function_1() {
        BigInteger b = new BigInteger("1564848946135861613216681215868413");
        BigInteger c = new BigInteger("1564848946135861613216681215868413");

        System.out.println(b);
        System.out.println(c);
        //BigInteger����������
        //���÷������㣬������Ҳֻ����BigInteger����

        //�ӷ�
        BigInteger add = b.add(c);
        System.out.println(add);
        //����
        BigInteger subtract = b.subtract(c);
        System.out.println(subtract);
        //�˷�
        BigInteger multiply = b.multiply(c);
        System.out.println(multiply);
        //����
        BigInteger divide = b.divide(c);
        System.out.println(divide);
    }
}
