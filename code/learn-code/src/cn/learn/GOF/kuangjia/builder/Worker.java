package cn.learn.GOF.kuangjia.builder;

public class Worker extends Builder {

    private Product product;

    public Worker() {
        product = new Product();
    }

    @Override
    void buildA() {
        product.setBuildA("�ػ�");
        System.out.println("�ػ�");
    }

    @Override
    void buildB() {
        product.setBuildB("�ֽ��");
        System.out.println("�ֽ��");
    }

    @Override
    void buildC() {
        product.setBuildC("�̵���");
        System.out.println("�̵���");
    }

    @Override
    void buildD() {
        product.setBuildD("��ˢ");
        System.out.println("��ˢ");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
