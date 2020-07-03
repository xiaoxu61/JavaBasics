package cn.learn.basic.Demo34Main;

public class Body {

    //内部类方法
    public class Heart{
        public void beat() {
            System.out.println("心脏跳动");
            System.out.println("我叫" + namel);
        }
    }

    //外部类方法
    public void methodBody() {
        System.out.println("外部的方法");
        new Heart().beat();
    }

    //外部类成员变量
    private String namel;

    public String getNamel() {
        return namel;
    }

    public void setNamel(String namel) {
        this.namel = namel;
    }



}
