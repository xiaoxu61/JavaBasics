package cn.learn.GOF.kuangjia.factory.abstractF;

//����Ĳ�Ʒ����
public interface IProductFactory {
    //�����ֻ�
    IphoneProduct iPhoneProduct();

    //����·����
    IRouterProduct iRouterProduct();
}
