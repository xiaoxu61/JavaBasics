package cn.learn.basic.Demo07Error;
/*
Throwable���еķ���
    ���������������쳣����Ϣ�й�ϵ
        String getMessage() ���쳣��Ϣ����ϸ����
        String toString() ���쳣��Ϣ�ļ������
        void printStackTrace ���쳣��Ϣ׷�ٵ���׼�Ĵ�����,�쳣��Ϣ��ȫ��JVMĬ�ϵ��÷���Ҳ���������
*/

public class Demo02Throwable {
    public static void main(String[] args) {
        try {
            function();
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
    }

    private static void function() throws Exception{
        throw new Exception("�쳣��");
    }
}
