package cn.learn.basic.Demo03;
/*
װ�䣺�ѻ������͵����ݣ���װ����װ���У������������� --> ��װ�ࣩ
    ���췽����
        Integer(int value)����һ���·���� Integer ��������ʾָ����intֵ
        Integer(String s) ����һ���·���� Integer ��������ʾString������ָʾ��intֵ
            ���ݵ��ַ��������ǣ��������͵��ַ�����������׳��쳣�����磺"100"��ȷ��"a"���쳣
    ��̬������
        static Integer valueOf(int i)����һ����ʾָ���� int ֵ��Integerʵ��
        static Integer valueOf(String s) ����ָ���� String ��ֵ�� Integer����
���䣺�ڰ�װ����ȡ���������͵�����  ��װ�� --> �������͵�����
    ��Ա����
        int intValue() �� int���ͷ��ظ�Integerֵ
*/

public class Demo06Integer {

    public static void main(String[] args) {
        //װ��
        Integer in1 = new Integer(1);//�������к��ߣ�˵��������ʱ��
        System.out.println(in1);

        Integer in2 = new Integer("2");
        System.out.println(in2);

        //��̬����
        Integer in3 = Integer.valueOf(1);
        Integer in31 = Integer.parseInt("2");
        System.out.println(in3 + in31);

//        Integer in4 = Integer.valueOf("a");//error:NumberFormatException���ݸ�ʽ���쳣
        Integer in4 = Integer.valueOf("1");
        System.out.println(in4);

        //����
        int i = in1.intValue();
        System.out.println(i);

        //Integer��ľ�̬��Ա����
        //MAX_VALUE MIN_VALUE
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        //������̬����
        //����ת��
        //ʮ����ת�ɶ����� toBinaryString(int)
        //ʮ����ת�ɰ˽��� toOctalString(int)
        //ʮ����ת��16���� toHexString(int)
        //������������ֵ����String��ʽ����
        System.out.println(Integer.toBinaryString(99));
        System.out.println(Integer.toOctalString(99));
        System.out.println(Integer.toHexString(999));

    }

}
