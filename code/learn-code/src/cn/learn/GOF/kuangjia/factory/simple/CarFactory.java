package cn.learn.GOF.kuangjia.factory.simple;
//��̬����ģʽ
//�����㿪��ԭ��
public class CarFactory {
    //����һ
    public static Car getCar(String car) {
        if (car.equals("����")) {
            return new WuLing();
        } else if (car.equals("Tesla")) {
            return new Tesla();
        }else {
            return null;
        }
    }

}
