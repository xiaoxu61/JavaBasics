package cn.learn.basic.Demo25;
/*
    String���ص㣺
        һ�ж��Ƕ����ַ�������""��Ҳ�Ƕ���
        �����������String�࣬�����ַ����������
        ���е�""������String��Ķ���

        �ַ�����һ��������һ���������ɸ���
        ���ֽ������е�ÿ���ֽڣ���ѯ�˱�����õ��Ľ��
        �ֽ��Ǹ��������ֵ��ֽڱ�����Ǹ�����Ĭ�ϱ����һ�����������ֽ�

        String(byte[] bytes, int offset, int length)�����ֽ�����
            �ֽ������һ����ת���ַ���
            offset�������ʼ����
            lengthȡ�ĸ�����ת����
*/

public class Demo03String {
    public static void main(String[] args) {
        String str = "tiCast";
        System.out.println(str);

        str = "itHeiMa";
        System.out.println(str);

        function();
        function1();
        function_2();
        function_3();
        function_4();
        function_5();
        function_6();
    }
    /*
        byte[] getBytes() ���ַ���ת���ֽ�����
        �˹��ܺ�String���췽���෴
        byte������صĹ��ܣ������ѯ�����
    */
    private static void function_6() {
        String s = "abc";

        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    /*
        int indexOf(char ch)
        ����һ���ַ������ַ����е�һ�γ��ֵ�����
        �����ҵ��ַ������ڣ�����-1
    */
    private static void function_5() {
        String s = "itCast.cn";

        int index = s.indexOf('x');
        System.out.println(index);
    }

    /*
        �ж�һ��һ���ַ����У��Ƿ������һ���ַ���
            boolean contains(String s)
    */
    private static void function_4() {
        String s = "itCast";

        boolean b = s.contains("Ca");
        System.out.println(b);
    }

    /*
        boolean startsWith(String prefix)
            �ж�һ���ַ����ǲ�����һ���ַ�����ǰ׺����ͷ
        boolean endsWith(String prefix)
            �ж�һ���ַ����ǲ�����һ���ַ�����ǰ׺����β
    */
    private static void function_3() {
        String s = "HowAreYou";
        boolean b = s.startsWith("H");
        System.out.println(b);

        boolean b1 = s.endsWith("ou");
        System.out.println(b1);
    }

    /*
        ��ȡ�ַ�����һ���֣�
            String substring(int beginIndex, int endIndex)
                ����ͷ��������β
            String substring(int beginIndex) ����ͷ��������ַ�ȫҪ
    */
    public static void function_2() {
        String s = "dfhdufvh14iufd";
        //����String�෽��substring��ȡ�ַ���һ����
        System.out.println(s.substring(1,5));

        System.out.println(s.substring(5));
    }
    /*
        String(char[] value) �����ַ�����
        ���ַ����飬ת���ַ������ַ�����Ĳ���������ѯ�����

        String(char[] bytes, int offset, int count)�����ֽ�����
    */
    public static void function1() {
        char[] ch = {'a','b','c'};

        String s = new String(ch);
        System.out.println(s);

        String s1 = new String(ch, 0, 2);
        System.out.println(s1);
    }
    /*
    ���巽����String��Ĺ��췽��
        String(byte[] bytes) �����ֽ�����
            ͨ��ʹ��ƽ̨��Ĭ���ַ�������ָ����byte���飬����һ���µ�String
                ƽ̨����������ϵͳ
                Ĭ���ַ���������ϵͳ��Ĭ�ϱ����Ĭ�ϱ����GBK
    */
    public static void function() {
        byte[] bytes = {-97, -98, -99, -100};
        String s = new String(bytes);
        System.out.println(s);

        byte[] bytes1 = {65, 66, 67, 68, 69};
        //����String���췽���������飬��������intֵ
        String s1 = new String(bytes1, 1, 2);
        System.out.println(s1);
        //�����ַ�������
        System.out.println(s1.length());
    }
}
