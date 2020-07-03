package cn.learn.basic.Demo25;


public class Demo06StringBuffer {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("weefdw");
        function();
        function_1();
        function_2();
        function_3();
        function_4();
        function_5();
    }
    /*
        String tostring() �̳�Object����дtoString
        ���������������ַ�����ַ���
    */
    private static void function_5() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("abcdef");
        buffer.append(123465);
        System.out.println(buffer);
        //���ɱ�Ļ��������󣬱���˲��ɱ��String����
        String s = buffer.toString();
        System.out.println(s);
    }

    /*
        reverse() �����������ַ���ת
    */
    private static void function_4() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("abcdef");
        buffer.reverse();
        System.out.println(buffer);
    }

    /*
        replace(int start, int end, String str)
        ��ָ����������Χ�������ַ����滻���µ��ַ���
    */
    private static void function_3() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("abcdef");
        buffer.replace(2,6, "QQ");
        System.out.println(buffer);
    }

    /*
        insert(int index, ��������)
            �������������ݣ����뵽��������ָ��������
    */
    public static void function_2() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("abcdef");
        buffer.insert(5, 5.5);
        System.out.println(buffer);
    }
    /*
        delete(int start, int end) ɾ���������ַ�
    */
    private static void function_1() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("abcdef");
        System.out.println(buffer);
        buffer.delete(1,5);
        System.out.println(buffer);
    }

    /*
        StringBuffer append,���������͵����ݣ���ӻ�����
        ����ֵ return this
        ��������˭������ֵ����˭
    */
    public static void function() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(6).append(false);
        System.out.println(buffer);
    }
}
