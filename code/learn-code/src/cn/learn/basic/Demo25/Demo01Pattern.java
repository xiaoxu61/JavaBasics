package cn.learn.basic.Demo25;
/*
������ʽ����ƥ����ϰ��
����
    1��"[0-9]{6,12}",����Ϊ6λ��12λ������
    2��"1[34578][0-9]{9}"��ʮһλ���ֻ����룬��2λΪ34578��һ��������9λΪ0��9֮����������
    3��"a*b"���ڶ��a�����a�����и�b��b����Ϊ���һ���ַ�

String��������������ʽ��صķ�����
    boolean matches(String ����Ĺ���)
    "abc".matches("[a]") ƥ��ɹ�����true

    String[] split(String ����Ĺ���)
    "abc".split("a")ʹ�ù����ַ��������и�

    String replaceAll(String �������, String �ַ���)
    "abc0123".replcaeAll("[\\d]", "#")
    ��װ����Ĺ����滻�ַ���
*/

public class Demo01Pattern {
    public static void main(String[] args) {
        checkQQ();
        checkPhone();
        split_1();
        split_2();
        replace_1();
        check_Email();
    }
    /*
       ����ʼ���ַ�Ƿ�Ϸ�������
            123456@qq.com
            mymail@sina.com
            nimail@163.com
            wodemail@yahoo.com

            @ǰ������������ĸ�»��ߣ�����δ֪����������һ��
            @�� . ǰ�棬������ĸ������������һ��
            . ����  ��ĸ
    */
    private static void check_Email() {
        String email = "abc133@sina.com.cn";
        boolean b = email.matches("[a-zA-Z0-9]+@[0-9a-z]+(\\.[a-z])+");
        System.out.println(b);
    }

    /*
        Hello12345World6789012 �����������滻��
        String�෽��replaceAll����������滻������ַ�����
    */
    private static void replace_1() {
        String str = "Hello12345World6789012";

        String str1 = str.replaceAll("[\\d]", "#");
        String str2 = str.replaceAll("[\\d]+", "#");
        System.out.println(str1);
        System.out.println(str2);
    }

    /*
        String�෽��split���ַ��������и�
        192.168.105.27 ����.�����и��ַ���
    */
    private static void split_2() {
        String ip = "192.168.105.27";
        String[] IPArr = ip.split("\\.+");
        for (int i = 0; i < IPArr.length; i++) {
            System.out.println(IPArr[i]);
        }
    }

    /*
        String�෽����split���ַ��������и�
        12-25-36-49 ����-���ַ��������и�
    */
    private static void split_1() {
        String str = "12-25-36-49";
        String[] split = str.split("-");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        String str1 = "ads  cd5 5s4              df54      sd";
        String[] str1Arr = str1.split(" +");
        for (int i = 0; i < str1Arr.length; i++) {
            System.out.println(str1Arr[i]);
        }
    }

    /*
        �ֻ�����1��ͷ��������34578��0-9λ�̶�11λ
    */
    private static void checkPhone() {
        String telNumber = "1335756852";
        boolean matches = telNumber.matches("1[34578][\\d]{9}");
        System.out.println(matches);
    }

    /*
        ���QQ�����Ƿ�Ϸ�
        0���ܿ�ͷ��ȫ���֣�λ��5��10λ
    */
    public static void checkQQ(){
        String QQ = "122234";
        //���QQ����͹����Ƿ�ƥ�䣬String��ķ���matches
        boolean b = QQ.matches("[1-9][\\d]{4,9}");
        System.out.println(b);
    }
}
