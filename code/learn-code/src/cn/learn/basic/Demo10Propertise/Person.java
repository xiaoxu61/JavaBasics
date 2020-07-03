package cn.learn.basic.Demo10Propertise;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    public   /*transient ��ֹ��Ա�����������л�*/int age;
    //���У��Լ����������кţ���ʹԴ����ı䣬������Ҳ�������¼������кţ����·������쳣
    private static final long serialVersionUID = 15684948142L;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
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

    @Override
    public String toString() {
        return "Person [ name=" + name + ",age=" + age + "]";
    }
}
