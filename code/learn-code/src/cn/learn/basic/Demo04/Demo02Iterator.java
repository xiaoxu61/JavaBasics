package cn.learn.basic.Demo04;
/*
    �����еĵ�������
        ��ȡ������Ԫ�ص�һ�ַ�ʽ
        �ӿ������������󷽷���
            boolean hasNext() �жϼ����л���û�п��Ա�ȡ������Ԫ�أ�����з���true
            next() ȡ�������е���һ��Ԫ��

        Iterator�ӿڣ���ʵ����
        Collection�ӿڶ��巽��
            Iterator iterator()
        ArrayList��д����iterator,������Iterator�ӿڵ�ʵ����Ķ���
        it�ǽӿڵ�ʵ������󣬵��÷���hasNext��next����Ԫ�ص���
JDK 1.5 �����µİ�ȫ���ƣ���֤����İ�ȫ��
    ���ͣ�ָ���˼����д洢���ݵ�����<��������>
*/

import java.util.*;

public class Demo02Iterator {
    public static void main(String[] args) {
        demo01();
        System.out.println("===========");
        demo02();
        System.out.println("===========");
        ArrayList<String> arr = new ArrayList<>();
        arr.add("123");
        arr.add("456");
        HashSet<Integer> set = new HashSet<>();
        set.add(567);
        set.add(789);
        iteractor(arr);
        iteractor(set);
        System.out.println("==============");
        demo03();
    }
    /*
        �������Ĳ����޸��쳣
        java.util.ConcurrentModificationException
        �ڱ��������У�ʹ���˼��ϵķ����޸��˼��ϵġ����ȡ������ǲ������
    */
    private static void demo03() {
        List<String> list = new ArrayList<>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");

        //�Լ���ʹ�õ��������л�ȡ����ȡʱ���жϼ������Ƿ���� "abc3" ����
        //����У����һ��Ԫ��"ABC3"
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            //�Ի�ȡ����Ԫ�ؽ����ж�
            if (s.equals("abc3")) {
                list.add("ABC3");
            }
            System.out.println(s);
        }
    }

    /*
        ���巽��������ͬʱ������������
        ��������ôʵ�֣��Ȳ���дArrayList��Ҳ����дHashSet
        ��������ͬʵ�ֵĽӿ�
        ���͵�ͨ�䣺ƥ�����е��������� ?
        ͨ����������ڱ�����������it��next()����ȡ��������Object���ͣ������� <? extends �޶��Ĺ̶���������>
        �޶��Ĺ̶��������Ϳ�����������࣬��������Դ���ȥ�����������Ĳ��ɴ���ȥ

        ? extends ����     ���Ƶ��Ǹ��࣬�����޶������Դ��������������
        ? super ����       ���Ƶ������࣬�����޶������Դ������ĸ������
    */
    private static void iteractor(Collection<?> coll) {
        Iterator<?> it = coll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static void demo02() {
        //�����п��Դ洢�������Ͷ���
        //�����У���ָ���洢���������ݣ�����ʲô����
        Collection coll = new ArrayList();
        coll.add("abc");
        coll.add("123ggd");

        //������ȡ
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            //iterator.next()��ȡ��������ʲô�࣬Object��
//            Object obj = iterator.next();
//            System.out.println(obj);
            //����Ҫʹ������������з���ʱ����Ҫ����ת��
            String s = (String)iterator.next();
            System.out.println(s.length());
        }
    }

    private static void demo01() {
        Collection<String> coll = new ArrayList<>();
        coll.add("AB1");
        coll.add("AB2");
        coll.add("AB3");
        coll.add("AB4");
        coll.add("AB5");
        //�����䣬�Լ���ArrayList�е�Ԫ�ؽ���ȡ��

        //���ü��Ϸ�����iterator() ��ȡ����Iterator�ӿڵ�ʵ����Ķ���
        Iterator<String> it = coll.iterator();
        //�ӿ�ʵ������󣬵��÷���hasNext()�жϼ������Ƿ���Ԫ��
        boolean b = it.hasNext();
        System.out.println(b);
        //�ӿڵ�ʵ������󣬵��÷���nextȡ�������е�Ԫ��
//        String next = it.next();
//        System.out.println(next);

        //�����Ƿ������ݣ�ʹ��ѭ��ʵ�֣�ѭ����������������û��Ԫ�أ�hasNext()������false
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);

        }
    }
}
