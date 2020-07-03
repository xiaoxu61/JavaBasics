package cn.learn.basic.Demo02Equal;

import java.util.Objects;

public class Person extends Object {
    String name;
    int age;
    /*
    Object���equal������Ĭ�ϱȽϵ�����������ĵ�ֵַ��û������
    ��������Ҫ��дequal�������Ƚ�������������ԣ�name��age��
    Ϊ�⣺
        ������һ����̬
        ��̬�ı׶ˣ��޷�ʹ���������е����ݣ����Ժͷ�����
        Object obj = p2 = new Person("��������", 19);
        ���������ʹ������ת�ͣ�ǿת����obj����ת��ΪPerson
    */
    /*@Override
    public boolean equals(Object obj) {
        //����һ���жϣ����ݵĲ���obj�����this����ֱ�ӷ���true��Ҳ����߳���Ч��
        if (obj == this) {
            return true;
        }
        //����һ���жϣ����ݵĲ���obj�����null��ֱ�ӷ���false
        if (obj == null) {
            return false;//��߳���Ч��
        }
        //����һ���жϣ���ֹ����ת���쳣
        if (obj instanceof Person) {
            Person p = (Person)obj;
            //�Ƚ϶��������,һ����this��һ���Ǵ��ݹ����Ķ���
            boolean b = this.name.equals(p.name) && this.age == p.age;
            return b;
        }
       return false;
    }*/
    //���ϴ��뻹������Generate�е�equals() and hashCode()�õ����´���
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //getClass() != o.getClass() ʹ�÷��似�����ж�o�Ƿ�ΪPerson����  ��Ч�� obj instanceof Person
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
