package cn.learn.GOF.kuangjia.builder;

//指挥：核心，负责指挥构建一个工程，工程如何构建，由他决定
public class Director {

    //指挥个人的建造顺序
    public Product build(Builder builder) {

        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();

        return builder.getProduct();
    }
}
