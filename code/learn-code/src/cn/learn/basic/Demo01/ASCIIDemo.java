package cn.learn.basic.Demo01;

/*
   ASCII�������ʾ
   �ַ�Java �������ͣ�char
   ����Java �������ͣ�int

   int���ͺ�char��������ת��
   char �����ֽڣ�int�ĸ��ֽ�
   charת��int���͵�ʱ�����������Զ�������char�������ͣ����ѯ������õ�����
   intת��char���͵�ʱ��ǿ��ת�������ѯ�����

   char�洢���֣���ѯUnicode�����

   char���Ժ�int���㣬����Ϊint���ͣ��ڴ��������ֽ�
   char ȡֵ��Χ0~65535
 */
public class ASCIIDemo {
    public static  void main(String[] args){
        char c = 'a';
        int i = c + 1;
        System.out.println(i);

        int j = 90;
        char h = (char)j;
        System.out.println(h);
        System.out.println((char)6);

        char k = '��';
        System.out.println(k);

        char b = 32766;

    }
}
