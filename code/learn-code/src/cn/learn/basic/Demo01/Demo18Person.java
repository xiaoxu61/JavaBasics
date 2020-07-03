package cn.learn.basic.Demo01;
/*
问题描述：定义person年龄时，无法阻止不合理的数组被设置进来
解决方案：用private关键字将需要保护的成员变量进行修饰

一旦使用了private进行修饰，那么类当中任然可以随便访问
但是，超出了本类范围之外就不能直接访问了

间接访问private成员变量，就是定义一对儿Getter/Setter方法

必须叫getXxx或者setXxx命名规则
对于Getter来说，不能有参数，返回值类型和成员变量对应。往里放
对应Setter来说，不能有返回值，参数类型和成员变量对应。往外拿

对于基本类型当中的boolea值，Getter方法一定要写成isXxx的形式，而setXxx规则不变
*/

public class Demo18Person {
    private String name;//姓名
    private int age;//年龄
    private boolean male; //是不是爷们

    public void show(){
        System.out.println("我叫" + name + "。今年" + age + "。是不是爷们" + male);
    }

    public void setMale(boolean b) {
        male = b;
    }

    public boolean isMale() {
        return male;
    }

    public void setName(String str) {
        name = str;
    }

    public String getName() {
        return name;
    }

    //这个成员方法，专门用于向age设置数据
    public void setAge(int num){
        if (num < 100 && num >= 9) {
            age = num;
        }else{
            System.out.println("数据不合理");
        }
    }

    //这个成员方法，专门获取age的数据
    public int getAge(){
        return age;
    }
}
