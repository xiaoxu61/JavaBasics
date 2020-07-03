package cn.learn.basic.Demo29;

public class Demo29NewPhone extends Demo29Phone {

    @Override
    public void show() {
        super.show();//把父类的show方法拿过啦重复利用
        //自己类再来添加更多内容
        System.out.println("显示姓名");
        System.out.println("显示头像");
    }
}
