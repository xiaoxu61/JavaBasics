package cn.learn.basic.Demo30;

public class User {
    private String name;//����
    private int balance;//���,��ǰ�û�ӵ�е�Ǯ��

    //չʾ��ǰ�û��ж���Ǯ
    public void show() {
        System.out.println("�ҽУ�" + name + "���ҵ����Ϊ��" + balance);
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
