package cn.learn.basic.Demo25;
/*
    ���ַ���������ĸת���ɴ�д����������ת��Сд
        ˼�룺
            ��ȡ����ĸsubString(0,1),ת�ɴ�дtoUpperCase()

            ��ȡʣ���ַ�����subString(1); toLowerCase()
*/

public class Demo04StringConver {
    public static void main(String[] args) {
        String s = toConvert("aFIUFCUSHU");
        System.out.println(s);
    }
    public static String toConvert(String str) {
        String first = str.substring(0,1);
        String after = str.substring(1);
        //����String�෽������д��Сдת��
        first = first.toUpperCase();
        after = after.toLowerCase();

        return first.concat(after);

    }
}
