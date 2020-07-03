package cn.learn.basic.Demo29;

public class Demo29PhoneUse {

    public static void main(String[] args) {
        Demo29Phone phone = new Demo29Phone();
        phone.call();
        phone.send();
        phone.show();
        System.out.println("====================");

        Demo29NewPhone newPhone = new Demo29NewPhone();
        newPhone.call();
        newPhone.send();
        newPhone.show();
    }
}
