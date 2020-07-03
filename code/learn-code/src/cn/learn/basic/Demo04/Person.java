package cn.learn.basic.Demo04;

public class Person {
    private String name;
    private int age;

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
    @Override
    public int hashCode() {
        return name.hashCode() + age*11;//�����˹�ϣֵ���ظ���
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null){
            return false;
        }
        if (obj instanceof Person) {
            Person p = (Person)obj;
            return name.equals(p.name) && age ==p.age;
        }
        return false;
    }
    @Override
    public String toString() {
        return name + "," +age;
    }

    public Person() {
    }
    /*
        û������д���࣬ÿ�����н�����ǲ�ͬ����
    */
    /*public int hashCode() {
        return 1;
    }*/
}
