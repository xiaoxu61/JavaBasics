package cn.learn.basic.Demo32Multi;
/*
��β���֪��һ���������õĶ��󣬱�����ʲô���ࣿ
��ʽ��
���� instanceof ������
�⽫��ĵ�һ��booleanֵ��Ҳ�����ж�ǰ��Ķ����ܲ��ܵ����������͵�ʵ��
*/

public class Demo02Instanceof {

    public static void main(String[] args) {
        Animal animal = new Dog();//������һֻè
        animal.eat();

        //ϣ������ת�ͣ��õ��������з���
        //�ж�һ�¸�������animal�����ǲ���Dog
        if (animal instanceof Dog) {
            Dog dog = (Dog)animal;
            dog.watchHouse();
        }
        //�ж�һ��animal�����ǲ���Cat
        if (animal instanceof Cat) {
            Cat cat = (Cat)animal;
            cat.catchMouse();
        }
        System.out.println("=======================");
        giveMePet(new Dog());
    }

    public static void giveMePet(Animal animal) {
        if (animal instanceof Dog) {
            Dog dog = (Dog)animal;
            dog.watchHouse();
        }
        //�ж�һ��animal�����ǲ���Cat
        if (animal instanceof Cat) {
            Cat cat = (Cat)animal;
            cat.catchMouse();
        }
    }

}
