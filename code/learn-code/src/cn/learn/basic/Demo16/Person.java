package cn.learn.basic.Demo16;

public class Person {
    public String name;
    private int age;

    static  {
        System.out.println("��̬�����");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(int age, String name) {
        this.age =age;
        this.name=name;
    }

    public Person() {
    }

    public void eat() {
        System.out.println(name + "�ڳԷ�");
    }

    public void sleep(String s, int a , double d) {
        System.out.println("����˯��" + s + "..." + a+"..."+ d);
    }

    private void playGamne() {
        System.out.println("���ڴ���Ϸ");
    }
}
