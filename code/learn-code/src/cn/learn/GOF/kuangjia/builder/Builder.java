package cn.learn.GOF.kuangjia.builder;

//����Ľ����� ������
public abstract class Builder {
    abstract void buildA();//�ػ�
    abstract void buildB();//�ֽ��
    abstract void buildC();//�̵���
    abstract void buildD();//��ˢ

    //�깤���õ�����
    abstract Product getProduct();
}
