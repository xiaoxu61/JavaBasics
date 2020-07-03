package cn.learn.basic.Demo30;

public class User {
    private String name;//姓名
    private int balance;//余额,当前用户拥有的钱数

    //展示当前用户有多少钱
    public void show() {
        System.out.println("我叫：" + name + "，我的余额为：" + balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public User(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public User() {
    }
}
