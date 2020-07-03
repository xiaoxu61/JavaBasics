package cn.learn.Data.Basic;
/*
    双向链表的实现
    分析双向链表的遍历、添加、修改、删除，
    1、遍历方向和单链表一样，只是可以向前，也可以向后查找
    2、添加（默认添加到双向链表的最后
        a：先找到双向链表的最后这个节点
        b：temp.next = newNode
        c：newNode.pre = temp
    3、修改的思路和原理与单链表一样
    4、删除
        a：因为是双向链表，因此，可以实现自我删除某个节点
        b：直接找到要删除的这个节点，比如temp
            temp.pre.next = temp.next
            temp.next.pre = temp.pre
*/

public class Demo05DoubleLinkedlist {
    public static void main(String[] args) {
        DoubleLinkedlist list = new DoubleLinkedlist();
        newHeroNode hero1 = new newHeroNode(1, "宋江", "及时雨");
        newHeroNode hero2 = new newHeroNode(2, "卢俊义", "玉麒麟");
        newHeroNode hero3 = new newHeroNode(3, "吴用", "智多星");
        newHeroNode hero4 = new newHeroNode(4, "林冲", "豹子头");
        //添加到链表后端
        /*list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.add(hero4);*/
        //按顺序添加
        list.addOrder(hero1);
        list.addOrder(hero4);
        list.addOrder(hero3);
        list.addOrder(hero2);
        list.list();
        /*list.list();
        System.out.println("修改后的链表");
        newHeroNode hero5 = new newHeroNode(4, "林", "豹子头~~");
        list.update(hero5);
        list.list();
        System.out.println("删除后的链表");
        list.delete(4);
        list.list();*/
    }
}
class DoubleLinkedlist{
    private newHeroNode head = new newHeroNode(0, "", "");

    public newHeroNode getHead() {
        return head;
    }
    //添加节点,在节点尾部添加
    public void add(newHeroNode node) {

        newHeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //循环退出，指向新的节点
        //形成双向链表
        temp.next = node;
        node.pre = temp;
    }

    //按照编号顺序添加双向链表
    public void addOrder(newHeroNode hero) {
        boolean flag = false;
        newHeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > hero.no) {
                break;
            }
            if (temp.next.no == hero.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("需要添加的英雄已存在");
        }else{

            if (temp.next != null) {//如果是链表结尾，则无需此操作
                hero.next = temp.next;
            }
            temp.next = hero;
            hero.pre = temp;
        }
    }

    //修改双向链表
    public void update(newHeroNode hero){
        if (head.next == null) {
            System.out.println("链表为空~无法修改");
            return;
        }
        newHeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == hero.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = hero.name;
            temp.nickName = hero.nickName;
        }else {
            System.out.printf("未匹配到需要修改编号%d",hero.no);
        }
    }

    //从双向链表中，删除一个节点
    //对于双向链表，直接找到需要删除节点，找到后直接删除
    public void delete(int no){
        if (head.next == null) {
            System.out.println("链表为空~~无法删除");
            return;
        }

        newHeroNode temp = head.next;
        boolean flag =false;
        while (true) {
            if (temp == null) {//遍历到最后，跳出循环
                break;
            }
            if (temp.no == no) {//找到待删除选项，跳出循环
                flag = true;
                break;
            }
            temp = temp.next;//temp后移，遍历
        }
        if (flag) {
            temp.pre.next = temp.next;
            //如果删除的是最后一个节点，则不需要执行下面的语句，否则会出现空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("未找到待删除节点"+no);
        }
    }
    //遍历双向链表
    public void list() {
        if (head.next == null){
            System.out.println("链表为空~~");
        }
        newHeroNode temp = head.next;
        while (true) {
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
    public void preList() {

    }
}

//建立数据
class newHeroNode{
    public int no;
    public String name;
    public String nickName;
    public newHeroNode next;//指向下一个节点
    public newHeroNode pre;//指向前一个节点

    public newHeroNode(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "newHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}