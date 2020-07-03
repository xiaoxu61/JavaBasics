package cn.learn.basic.Demo04;
/*
JDK 1.5֮��������ԣ���ǿforѵ��
    �����µĽӿ�java.lang.Iterable   ʵ������ӿ���������Ϊ"foreach"����Ŀ��
    Collection��ʼ�̳�Iterable
    Iterable���ã�ʵ����ǿforѭ��

    ��ʽ��
        for(�������� ������ : ������߼���) {
            sop(����)
        }

    �ô����������٣��������
    �׶ˣ�û�����������ܲ��������ڵ�Ԫ��
*/

public class Demo03ForEach {
    public static void main(String[] args) {
        demo01();
        System.out.println("==========");
        demo02();
        System.out.println("===========");
        demo03();
    }
    /*
        ��ǿforѭ����������
        �洢�Զ���Person����
    */
    private static void demo03() {
    }

    private static void demo02() {
        //for���ڶ������������ʱ���ܷ���ö���ķ�����
        String[] arr = {"acb","gds","sdv"};
        for (String s : arr) {
            System.out.print(s);
            System.out.println(s.length());
        }
    }

    /*
        ʵ��forѭ������������
        �ô����������٣��������
        �׶ˣ�û�����������ܲ��������ڵ�Ԫ��
    */
    private static void demo01() {
        int[] arr = {3,1,5,6,8,1,7,9};
        for (int i : arr) {
            System.out.println(i+1);
        }
        System.out.println(arr[0]);
    }
}
