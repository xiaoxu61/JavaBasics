package cn.learn.basic.Demo16;
/*
    ���弯���࣬����String
    Ҫ���򼯺������Integer����

    ���䷽ʽ����ȡ������ArrayList���class�ļ�����
    ͨ��class�ļ����󣬵���add����

*/

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Demo07Reflect {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> array = new ArrayList<>();
        array.add("a");
        //���䷽ʽ����ȡ������ArrayList���class�ļ�����
        Class c = array.getClass();
        //��ȡArrayList.class�ļ��еķ���add
        Method method = c.getMethod("add", Object.class);
        System.out.println(method);

        //ʹ��invoke����ArrayList����add
        method.invoke(array, 150);
        method.invoke(array, 10);
        method.invoke(array, 1500);

        System.out.println(array);
    }
}
