package cn.learn.basic.Demo05;
/*
    Map�ӿڵĳ��÷���
        ʹ��Map�ӿڵ�ʵ����HashMap
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo01Map {
    public static void main(String[] args) {
        demo01();
        System.out.println("===========");
        demo02();
        System.out.println("===========");
        demo03();
        System.out.println("===========");
        demo04();
    }
    /*
        Map���ϻ�ȡ��ʽ
        entrySet��������ֵ��ӳ���ϵ��ȡ
        ʵ�ֲ��裺
                1������map���Ϸ���entrySet()�������е�ӳ���ϵ���󣬴洢��Set����
                    Set<Entry <K, V> >
                2������Set����
                3����ȡ����Set���ϵ�Ԫ�أ���ӳ���ϵ����
                4��ͨ��ӳ���ϵ���󷽷�getKey��getValue��ȡ��ֵ��
         �����ڲ������  �ⲿ��.�ڲ��� = new ...
    */
    private static void demo04() {
        Map<Integer, String> map = new HashMap<>();
        map.put(11, "a");
        map.put(22, "b");
        map.put(33, "c");

        //1
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        //2
        Iterator<Map.Entry<Integer, String>> it = set.iterator();
        while (it.hasNext()) {
            //3
            Map.Entry<Integer, String> entry = it.next();
            //4
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "..." + value);
        }
        System.out.println("==============");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "..." + entry.getValue());
        }
    }

    /*
        Map���ϵı���
            ���ü�����ȡֵ
            Map�ӿ��ж��巽��keySet�����еļ����洢��Set����

    */
    private static void demo03() {
        //1������map���ϵķ���keySet�����еļ��洢��Set������
        //2������Set���ϣ���ȡ��Set�����е�����Ԫ�أ�Map�еļ���
        //3������map���Ϸ���get��ͨ������ȡ��ֵ
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 11);
        map.put("b", 22);
        map.put("c", 33);
        map.put("d", 44);

        Set<String> set = map.keySet();

        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String key = it.next();
            Integer value = map.get(key);
            System.out.println(key+ "...." + value);
        }
        for (String s : map.keySet()) {
            Integer v = map.get(s);
            System.out.println(s + "..." + v);
        }
    }

    /*
        ͨ�������󣬻�ȡֵ����
        V get(K)
        ���������û�������������null
    */
    private static void demo02() {
        //�������϶�����Ϊ���Ķ���������ֵ�Ķ���洢�ַ���
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(5, "a");
        map.put(4, "b");
        map.put(3, "c");
        System.out.println(map);
        //�Ƴ������еļ�ֵ�ԣ����ر��Ƴ�֮ǰ��ֵ
        // V remove(K)
        String value1 = map.remove(4);
        System.out.println(value1);
        System.out.println(map);

        String value = map.get(5);
        System.out.println(value);
    }

    /*
        ����ֵ�Դ洢��������
        V put(k, V) K��Ϊ���Ķ���V��Ϊֵ�Ķ���
        �洢���ظ��ļ�����ԭ�е�ֵ������
        ����ֵ��һ������·���null�����洢�ظ�����ʱ�򣬷��ر�����֮ǰ��ֵ
    */
    private static void demo01() {
        //�������϶���HashMap���洢���󣬼����ַ�����ֵ������
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 1);
        Integer i = map.put("a", 2);
        map.put("c", 3);
        map.put("c", 5);
        System.out.println(map);
        System.out.println(i);
    }
}
