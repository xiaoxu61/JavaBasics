package cn.learn.basic.Demo03;
/*
java.lang.System �����ṩ�˴����ľ�̬���������Ի�ȡ��ϵͳ��ص���Ϣ��ϵͳ����������System���API�ĵ��У����õķ����У�
    public static long currentTimeMills()�����غ���Ϊ��λ�ĵ�ǰʱ��
    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, ing length)����������ָ�������ݿ�������һ��������
*/

import java.sql.SQLOutput;
import java.util.Arrays;

public class Demo04System {
    public static void main(String[] args) {
        //��ȡ��ǰ����ϵͳ����
        System.out.println(System.getProperties());
        demo01();
        System.out.println("================");
        demo02();
        System.out.println("============");
        demo04();
        System.out.println("============");
        demo03();
    }
    /*
        JVM���ڴ��У���ȡ���������
        static void gc()
    */
    private static void demo04() {
        new Person();
        System.gc();
    }

    /*
        �˳�����������г���ֹͣ
        static void exit(0)
    */
    private static void demo03() {
        while (true) {
            System.out.println("Hello");
            System.exit(0);
        }
    }

    /*
    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, ing length)����������ָ�������ݿ�������һ��������
    ������
        src - Դ���顣Ҫ���Ƶ�����
        srcPos - Դ�����е���ʼλ��(��ʼ����)��
        dest - Ŀ�����顣
        destPos - Ŀ�������е���ʼλ�á�
        length - Ҫ���Ƶ�����Ԫ�ص�������
    ��ϰ��
        ��src������ǰ3��Ԫ�أ����Ƶ�dest�����ǰ����λ���ϣ�
        ����Ԫ��ǰ��src����Ԫ��[1, 2, 3, 4, 5],dest����[6, 7, 8, 9, 10]
        ����Ԫ�غ�src����Ԫ��[1, 2, 3, 4, 5],dest����[1, 2, 3, 9, 10]
    */
    private static void demo02() {
        //����ԭ����
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = {6, 7, 8, 9, 10};
        System.out.println("����ǰ" + Arrays.toString(dest));
        //ʹ��System���е�arraycopy��Դ�����ǰ3��Ԫ�ظ��Ƶ�Ŀ�������ǰ3��λ����
        System.arraycopy(src, 0, dest, 0, 3);
        System.out.println("���ƺ�" + Arrays.toString(dest));

    }

    /*
    public static long currentTimeMills()�����غ���Ϊ��λ�ĵ�ǰʱ��
    ������֤�����Ч��
    ��֤forѭ����ӡ����1~9999����Ҫʹ�õ�ʱ��
    */
    private static void demo01() {
        //����ִ��ǰ����ȡһ�κ���ֵ
        long s = System.currentTimeMillis();
        for (int i = 0; i < 99; i++) {
            System.out.println(i);
        }
        long e = System.currentTimeMillis();
        System.out.println("���򹲺�ʱ��" + (e - s) + "����");
    }
}
