package cn.learn.basic.Demo34Main;

public class Body {

    //�ڲ��෽��
    public class Heart{
        public void beat() {
            System.out.println("��������");
            System.out.println("�ҽ�" + namel);
        }
    }

    //�ⲿ�෽��
    public void methodBody() {
        System.out.println("�ⲿ�ķ���");
        new Heart().beat();
    }

    //�ⲿ���Ա����
    private String namel;

    public String getNamel() {
        return namel;
    }

    public void setNamel(String namel) {
        this.namel = namel;
    }



}
