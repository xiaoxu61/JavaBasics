package cn.learn.basic.Demo24;
/*
1���Զ����ĸ�ѧ��������ӵ����ϲ�����

˼·��
    1���Զ���Studentѧ���࣬�ĸ�����
    2������һ�����ϣ������洢ѧ�����󣬷��ͣ�<Student>
    3�������࣬�����ĸ�ѧ������
    4�����ĸ�ѧ��������ӵ������У�add
    5���������ϣ�for��size��get

2��������ָ����ʽ��ӡ���ϵķ�����ArrayList������Ϊ��������ʹ��{}���������ϣ�ʹ��@�ָ�ÿ��Ԫ��
   ��ʽ����{Ԫ��@Ԫ��@Ԫ��}

*/

import cn.learn.ClassDefine.Student;

import java.util.ArrayList;

public class Demo24ArrayListStudent {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Student one = new Student("���߹�",50);
        Student two = new Student("����ү",26);
        Student three = new Student("���",20);
        Student four = new Student("����ү",10);
        //����˿�
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);

        //�����˿�
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println("С�ӣ�" + stu.getName() + ",���䣺" + stu.getAge());
        }
        System.out.println("==========================");
        System.out.println(list);
        printAarrayList(list);
    }
    /*
    ���巽������Ҫ��
        ����ֵ���ͣ�ֻ�ǽ��д�ӡ���ѣ�û�����㣬û�н����������void
        �������ƣ�printArraylist
        �����б�ArrayList
    */
    public static void printAarrayList(ArrayList<Student> list){
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            Student temp = list.get(i);
            if(i < list.size() - 1){
                System.out.print(temp.getName() + "@");
            }else{
                System.out.println(temp.getName() + "}");
            }
        }
    }
}
