package cn.learn.basic.Demo35Red;

public class User {
    private String name;
    private double money;

    public void show() {
        System.out.println("我是：" + name + "，我有：" + money + "元");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public User(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public User() {
    }
}
