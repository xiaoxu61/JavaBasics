package cn.learn.basic.Demo02Equal;

import java.util.Objects;

public class Person extends Object {
    String name;
    int age;
    /*
    Object类的equal方法，默认比较的是两个对象的地址值，没有意义
    所以我们要重写equal方法，比较两个对象的属性（name，age）
    为题：
        隐含着一个多态
        多态的弊端：无法使用子类特有的内容（属性和方法）
        Object obj = p2 = new Person("古力娜扎", 19);
        解决：可以使用向下转型（强转）把obj类型转换为Person
    */
    /*@Override
    public boolean equals(Object obj) {
        //增加一个判断，传递的参数obj如果是this本身，直接返回true，也可提高程序效率
        if (obj == this) {
            return true;
        }
        //增加一个判断，传递的参数obj如果是null，直接返回false
        if (obj == null) {
            return false;//提高程序效率
        }
        //增加一个判断，防止类型转换异常
        if (obj instanceof Person) {
            Person p = (Person)obj;
            //比较对象的属性,一个是this，一个是传递过来的对象
            boolean b = this.name.equals(p.name) && this.age == p.age;
            return b;
        }
       return false;
    }*/
    //以上代码还可以在Generate中的equals() and hashCode()得到如下代码
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //getClass() != o.getClass() 使用反射技术，判断o是否为Person类型  等效于 obj instanceof Person
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
