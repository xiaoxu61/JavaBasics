package cn.learn.basic.Demo32Multi;

public class Computer {

    public void powerOn() {
        System.out.println("�ʼǱ�����");
    }

    public void powerOf() {
        System.out.println("�ʼǱ��ػ�");
    }

    //ʹ��USB�豸�ķ�����ʹ�ýӿ���Ϊ�����Ĳ���
    public void usbDevice(USB usb) {
        usb.open();
        if (usb instanceof Mouse) {
            Mouse mouse = (Mouse)usb;
            mouse.chick();
        }else if (usb instanceof Keyboard){
            Keyboard keyboard = (Keyboard)usb;
            keyboard.type();
        }

        usb.close();
    }

}
