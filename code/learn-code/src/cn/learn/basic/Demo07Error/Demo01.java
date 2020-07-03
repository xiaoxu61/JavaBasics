package cn.learn.basic.Demo07Error;
/*
Throwable
 Exception �������Ĵ��󣬿ɽ��쳣����������Լ���ִ��
    JVM��
        1���������쳣�Ķ���
        2�����쳣�Ķ�������׳����ӳ�ȥ�ˣ��׸������ĵ�����
        ע�⣺һ���쳣���׳�����������г��򡾲���ִ�С�
 Error ��������أ������޸ĳ���ſ�����
    JVM��
        1�����쳣��Ϣ���Ժ�ɫ�����������̨
        2��������ֹͣ������

  �����쳣���������׳��쳣�ķ��������������ʧ�ܣ�try throws������
  �����쳣���׳����쳣ʱRuntimeException����������������

  �����쳣���ص㣺
        �����ڲ��׳����쳣�������쳣��new XXXException
        �����������ϣ�����Ҫthrows��䣬�����ߣ�����Ҫ����
        ���ԭ��
            �����쳣�����ܷ�����������������ˣ�������Աֹͣ�����޸�Դ����

            �����쳣��һ����������Ҫ���������޸�Դ���롣�����쳣һ������������Ĵ���û��ִ�е�����


*/

public class Demo01 {
    public static void main(String[] args) throws Exception {
        int[] arr = null;
//        System.out.println(arr[3]);//ArrayIndexOutOfBoundsException����Խ���쳣
//        int[] array = new int[999999999];//OutOfMemoryError �������
//        System.out.println(array[3]);
        int i = demo01(arr);
        System.out.println(i);
    }
    /*
        �쳣�еĹؼ���
            throw���ڷ����ڲ����׳��쳣�Ķ���
            throw���棬����дnew ���󣬱������쳣�Ķ��󣬱�����Exception��������

            �����������쳣�ؼ��֣�
                throws ���ڷ����������ϣ������˷������ܳ����쳣��������ߴ���
                throws �������д�쳣�������

               ������һ���׳��쳣�ķ����������߾ͱ��봦��
               ����������ʧ��

    */
    private static int demo01(int[] arr) throws Exception {
        //�Է����������кϷ��Ե��жϣ������ж��ǲ���null
        if(arr == null) {
            //�׳��쳣����ʽ�����ߵ�����
            //�ؼ���throw
            throw new Exception("�������鲻����");
        }
        //����������жϣ��ж��������ǲ�����Ԫ��
        if (arr.length == 0) {
            //�׳��쳣����ʽ�����ߵ����ߣ�����û��Ԫ��
            throw new Exception("������û���κ�Ԫ��");
        }
        int i = arr[arr.length - 1];
        return i*2;
    }
}
