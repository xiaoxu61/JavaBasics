package cn.learn.Data.Basic;
/*
    ��һ����˾�������µ�Ա��������ʱ��Ҫ�󽫸�Ա������Ϣ����(id, �Ա�,����,סַ)
    �������Ա����idʱ��Ҫ����ҵ���Ա����������Ϣ
    Ҫ��
        ��ʹ�����ݿ⣬�ٶ�Խ��Խ��
        ���ʱ����֤id�ӵ͵��߲���
            1��ʹ��������ʵ�ֹ�ϣ������������ͷ
            2��˼·����������ʾ��ͼ
            3������ʵ�֡���ɾ�Ĳ顿��id��ѯ
*/

import java.util.Scanner;

public class Demo13HashTable {
    public static void main(String[] args) {
        //������ϣ��
        HashTab hashTab = new HashTab(7);

        //дһ���򵥵Ĳ˵�
        String key = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("add����ӹ�Ա");
            System.out.println("list����ʾ��Ա");
            System.out.println("find�����ҹ�Ա");
            System.out.println("delete��ɾ����Ա");
            System.out.println("exit���˳�ϵͳ");
            key = sc.next();
            switch (key) {
                case "add":
                    System.out.println("����id");
                    int id = sc.nextInt();
                    System.out.println("��������");
                    String name = sc.next();
                    //������Ա
                    hashTab.add(new Emp(id, name));
                    break;
                case "find":
                    System.out.println("��������Ҫ���ҵ�id");
                    id = sc.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "delete":
                    System.out.println("��Ա��ϢΪ��");
                    hashTab.list();
                    System.out.println("��������Ҫɾ���Ĺ�Աid");
                    id = sc.nextInt();
                    hashTab.deleteById(id);
                    break;

                case "list":
                    hashTab.list();
                    break;

                case "exit":
                    sc.close();
                    System.exit(0);
            }
        }
    }
}

//����HashTable �����������
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;//�ж���������

    //������
    public HashTab(int size) {
        this.size = size;
        //��ʼ��empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //��Ҫ���˷ֱ��ʼ��ÿ������
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //��ӹ�Ա
    public void add(Emp emp) {
        //����Ա����ID���ж�Ա������ӵ���������
        int empLinkedListNO = hashFun(emp.id);
        //��emp��ӵ�����������
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    //������������
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i + 1);
        }
    }

    //��������id���ҹ�Ա
    public void findEmpById(int id) {
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].FindEmpById(id);

        if (emp != null) {
            System.out.printf("�ڵ�%d���������ҵ�idΪ%d�Ĺ�Ա%s\n",(empLinkedListNO + 1),id,emp.name);
        }else {
            System.out.println("�ڹ�ϣ����û���ҵ��ù�Ա");
        }
    }

    //��������id��ɾ����Ӧ�����иù�Ա����Ϣ
    public void deleteById(int id) {
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].deleteById(id);
        if (emp != null) {
            System.out.printf("�ڵ�%d��������ɾ��idΪ%d�Ĺ�Ա%s\n",(empLinkedListNO + 1),id,emp.name);
        }else {
            System.out.println("�ڹ�ϣ����û���ҵ��ù�Ա");
        }
    }

    //��дɢ�к�����ʹ��һ����ȡģ��
    public int hashFun(int id) {
        return id % size;
    }
}

//��ʾһ����Ա
class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//����EmpLinkedList,��ʾһ������
class EmpLinkedList{
    //ͷָ�룬ָ���һ��Emp
    private Emp head;

    //��ӹ�Ա���б�
    //˵�����ٶ���ӹ�Աʱ��id���������ģ���id�������Ǵ�С����
    public void add(Emp emp) {
        //����ǵ�һ����Ա
        if (head == null) {
            head = emp;
            return;
        }
        /*if (head.id == emp.id){
            System.out.println("id�ظ������ʧ��");
            return;
        }*/
        //������ǵ�һ����Ա
        Emp curEmp = head;
        boolean flag = false;
        while (true) {
            if (curEmp.id == emp.id) {
                flag = true;
                break;
            }
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        if (flag){
            System.out.println("id���ظ�");
        }else {
            curEmp.next = emp;
        }
    }

    //������Ա��Ϣ
    public void list(int no) {
        System.out.print("��"+no +"������");
        if (head == null) {
            System.out.println("Ϊ��");
            return;
        }
        Emp curEmp = head;
        while (true) {
            System.out.print("[id=" + curEmp.id +"   name=" + curEmp.name+"] ");
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    //����id���ҹ�Ա
    //����ҵ����ͷ���Emp��û�ҵ��ͷ���null
    public Emp FindEmpById(int id) {
        if (head == null) {
            System.out.println("����Ϊ�գ��޷�����");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break;
            }
            if (curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    //ɾ����Ա
    public Emp deleteById(int id) {
        if (head == null) {
            System.out.println("ɾ��������Ϊ��");
            return null;
        }
        Emp empTemp;
        //���ɾ������ͷ�ļ����򽫸�����ͷ����һ����Ϊ����ͷ
        if (head.id == id) {
            empTemp = head;
            head = head.next;
            return empTemp;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                empTemp = null;
                break;
            }
            if (curEmp.next.id == id) {
                empTemp = curEmp;
                curEmp.next = curEmp.next.next;
                break;
            }
            curEmp = curEmp.next;
        }
        return empTemp;
    }
}