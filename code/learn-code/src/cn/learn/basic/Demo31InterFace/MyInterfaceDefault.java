package cn.learn.basic.Demo31InterFace;
/*
��Java 8 ��ʼ���ӿ�������Ĭ�Ϸ���
��ʽ��
public default ����ֵ���� ��������(�����б�) {
    ������
}

��ע���ӿڵ��е�Ĭ�Ϸ��������Խ���ӿ�����������
*/


public interface MyInterfaceDefault {

    public abstract void methodAbs();

    //�������һ�����󷽷���������֤��ӷ����󲻱���
//    public abstract void methodAbs2();
    //����ӵķ�����ΪĬ�Ϸ������ܽ��
    public default void methodDefault() {
        System.out.println("��������ӵ�Ĭ�Ϸ���");
    }

}
