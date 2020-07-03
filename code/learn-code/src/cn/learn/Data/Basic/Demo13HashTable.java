package cn.learn.Data.Basic;
/*
    有一个公司，当有新的员工来报道时，要求将该员工的信息加入(id, 性别,年龄,住址)
    当输入该员工的id时，要求查找到该员工的所有信息
    要求：
        不使用数据库，速度越快越好
        添加时，保证id从低到高插入
            1、使用链表来实现哈希表，该链表不带表头
            2、思路分析并画出示意图
            3、代码实现【增删改查】按id查询
*/

import java.util.Scanner;

public class Demo13HashTable {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);

        //写一个简单的菜单
        String key = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("add：添加雇员");
            System.out.println("list：显示雇员");
            System.out.println("find：查找雇员");
            System.out.println("delete：删除雇员");
            System.out.println("exit：退出系统");
            key = sc.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = sc.nextInt();
                    System.out.println("输入名字");
                    String name = sc.next();
                    //创建雇员
                    hashTab.add(new Emp(id, name));
                    break;
                case "find":
                    System.out.println("请输入需要查找的id");
                    id = sc.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "delete":
                    System.out.println("成员信息为：");
                    hashTab.list();
                    System.out.println("请输入需要删除的雇员id");
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

//创建HashTable 管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;//有多少条链表

    //构造器
    public HashTab(int size) {
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //不要忘了分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工的ID，判断员工该添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp添加到对于链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    //遍历所有链表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i + 1);
        }
    }

    //根据输入id查找雇员
    public void findEmpById(int id) {
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].FindEmpById(id);

        if (emp != null) {
            System.out.printf("在第%d条链表中找到id为%d的雇员%s\n",(empLinkedListNO + 1),id,emp.name);
        }else {
            System.out.println("在哈希表中没有找到该雇员");
        }
    }

    //根据输入id，删除相应链表中该雇员的信息
    public void deleteById(int id) {
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].deleteById(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中删除id为%d的雇员%s\n",(empLinkedListNO + 1),id,emp.name);
        }else {
            System.out.println("在哈希表中没有找到该雇员");
        }
    }

    //编写散列函数，使用一个简单取模法
    public int hashFun(int id) {
        return id % size;
    }
}

//表示一个雇员
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

//创建EmpLinkedList,表示一条链表
class EmpLinkedList{
    //头指针，指向第一个Emp
    private Emp head;

    //添加雇员到列表
    //说明：假定添加雇员时，id是自增长的，即id分配总是从小到大
    public void add(Emp emp) {
        //如果是第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        /*if (head.id == emp.id){
            System.out.println("id重复，添加失败");
            return;
        }*/
        //如果不是第一个雇员
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
            System.out.println("id号重复");
        }else {
            curEmp.next = emp;
        }
    }

    //遍历雇员信息
    public void list(int no) {
        System.out.print("第"+no +"条链表：");
        if (head == null) {
            System.out.println("为空");
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

    //根据id查找雇员
    //如果找到，就返回Emp，没找到就返回null
    public Emp FindEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空，无法查找");
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

    //删除成员
    public Emp deleteById(int id) {
        if (head == null) {
            System.out.println("删除的链表为空");
            return null;
        }
        Emp empTemp;
        //如果删除的是头文件，则将该链表头的下一个作为链表头
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