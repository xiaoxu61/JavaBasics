package cn.learn.basic.Demo04;
/*
    Set�ӿڣ��ص㲻�ظ�Ԫ�أ�û����

    Set�ӿڵ�ʵ���࣬HashSet����ϣ��
    �ص㣺���򼯺ϣ��洢��ȡ����˳��ͬ��û�����������洢�ظ�Ԫ��
    ����ı�д�Ϻ�ArrayList��ȫһ��

    HashSet���ϵ������ص㣺
        �ײ����ݽṹ����ϣ��
        �洢��ȡ�����ȽϿ�
        �̲߳���ȫ�������ٶȿ�
      ��ϣ�Ĵ洢���̣�
                    ���������Ĺ�ϣֵ���Ѵ�������ж�����бȽϣ�
                        ����ͬ���򽫴�ֵ����
                        ����ͬ������equal���бȽ�
                            ����ͬ���򲻴�
                            ������ͬ������������ϣֵ��ͬ��ԭ�������±ߣ�����ס���ĵ�ַ
*/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo06Set {
    public static void main(String[] args) {
        demo01();
        System.out.println("==================");
        demo02();
        System.out.println("==================");
        demo03();
    }

    private static void demo03() {
        HashSet<String> set = new HashSet<>();
        set.add("abc");
        set.add("abc");
        set.add("bbc");
        set.add("bbc");
        System.out.println(set);
        //��Person�����е�������������ͬ���ݣ�������һ������
        //�ж϶����Ƿ��ظ������������Լ��ķ���hashCode��equals
        //��д��Ŀ�꣬�ö���������ֵname��age�������ֵ��ͬ���õ���ͬ�Ĺ�ϣֵ
        HashSet<Person> people = new HashSet<>();
        people.add(new Person("a", 15));
        people.add(new Person("b", 14));
        people.add(new Person("b", 19));
        people.add(new Person("b", 19));
        people.add(new Person("c", 13));

        System.out.println(people);

    }

    /*
        ����Ĺ�ϣֵ����ͨ��ʮ��������
        ����Object������public int hashCode() ������int����
    */
    private static void demo02() {
        /*Person person = new Person();
        int i = person.hashCode();//���صĽ���ǲ�����
        System.out.println(i);*/

        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1.hashCode());//96354
        System.out.println(s2.hashCode());//96354
        /*
           ��ϣֵ�ļ�����̣�31*ԭ���ļ����� + �ַ�ASCIIֵ
            "abc" --> char[] {'a','b','c'}
            h = 31*0 + char[0] = 31*0 + 'a' = 31*0 +97 = 97
            h = 31*97 + char[1] = 31*97 + 'b' = 31*97 +98 = 3105
            h = 31*3105 + char[2] = 31*3105 + 'c' = 31*3105 + 99 = 96354
        */
    }

    private static void demo01() {
        Set<String> set = new HashSet<>();
        set.add("cn");
        set.add("itCast");
        set.add("heima");
        set.add("java");

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for (String s : set) {
            System.out.println(s);
        }
    }
}
