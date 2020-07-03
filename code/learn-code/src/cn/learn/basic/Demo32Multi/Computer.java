package cn.learn.basic.Demo32Multi;

public class Computer {

    public void powerOn() {
        System.out.println("笔记本开机");
    }

    public void powerOf() {
        System.out.println("笔记本关机");
    }

    //使用USB设备的方法，使用接口作为方法的参数
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
