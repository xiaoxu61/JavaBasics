package cn.learn.GOF.kuangjia.builder;

//ָ�ӣ����ģ�����ָ�ӹ���һ�����̣�������ι�������������
public class Director {

    //ָ�Ӹ��˵Ľ���˳��
    public Product build(Builder builder) {

        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();

        return builder.getProduct();
    }
}
