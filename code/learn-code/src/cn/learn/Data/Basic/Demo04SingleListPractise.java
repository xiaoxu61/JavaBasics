package cn.learn.Data.Basic;
/*
    合并两个有序的单链表，合并以后依然有序
*/

public class Demo04SingleListPractise {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(5, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(7, "林冲", "豹子头");

        HeroNode hero5 = new HeroNode(2, "宋江", "及时雨");
        HeroNode hero6 = new HeroNode(4, "卢俊义", "玉麒麟");
        HeroNode hero7 = new HeroNode(6, "吴用", "智多星");
        HeroNode hero8 = new HeroNode(8, "林冲", "豹子头");

        SingleList singleList = new SingleList();
        singleList.add(hero1);
        singleList.add(hero2);
        singleList.add(hero3);
        singleList.add(hero4);

        SingleList singleList1 = new SingleList();
        singleList1.add(hero5);
        singleList1.add(hero6);
        singleList1.add(hero7);
        singleList1.add(hero8);
        System.out.println("链表1为：");
        singleList.list();
        System.out.println("链表2为");
        singleList1.list();
        System.out.println("合并后的链表为");

        /*HeroNode heroNode = mergeNoRecursion2(singleList.getHead(), singleList1.getHead());
        SingleList list = new SingleList();

        list.add(heroNode);
        list.list();*/
        HeroNode heroNode = mergeList(singleList.getHead(),singleList1.getHead());
        SingleList list = new SingleList();
        list.add(heroNode);
        list.list();


    }
    public static HeroNode mergeList(HeroNode head, HeroNode head2) {

        //若连个链表为空，那就返回null
        if (head.next == null || head2.next == null) {
            return head.next == null ? head2 : head;
        }
        HeroNode newNode = new HeroNode(0,"", "");
        /*if (head.next.NO >= head2.next.NO){
             newNode = head2.next;
        }else {
             newNode = head.next;
        }*/
        HeroNode point = newNode;
        HeroNode temp = head.next;
        HeroNode temp1 = head2.next;
        while (temp != null && temp1 != null) {
            if (temp.NO <= temp1.NO) {
                point.next = temp;
                temp = temp.next;
            }else{
                point.next = temp1;
                temp1 = temp1.next;
            }
            point = point.next;
        }
        point.next = temp == null ? temp1 : temp;
        return newNode.next;
    }
    /**
     * 非递归算法---简化
     */

    public static HeroNode mergeNoRecursion2(HeroNode node1, HeroNode node2) {
        // 合并1，2
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }

        // head记录合并后链表的表头(理解有边的代码)
        HeroNode head = node1.NO <= node2.NO ? node1 : node2;

        // list1,list2用来记录两链表当前位置
        HeroNode list1 = head == node1 ? node1 : node2;
        HeroNode list2 = head == node1 ? node2 : node1;

        // point用来指向合并链表的下一个节点
        HeroNode point = head;
        list1 = list1.next;// 开始时已经指向了list1的表头，后面的比较list1要从第二个开始

        // 使用循环遍历两个链表，根据list1.data和list2.data的比较结果，决定point下一节点
        while (list1 != null && list2 != null) {
            if (list1.NO <= list2.NO) {
                // list1.data <= list2.data 首先更新point的下一节点list1，然后更新list1的位置
                point.next = list1;
                list1 = list1.next;
            } else {
                // list1.data > list2.data 首先更新point的下一节点list2，然后更新list2的位置
                point.next = list2;
                list2 = list2.next;
            }
            // 更新point的位置为它的下一节点
            point = point.next;
        }

        /*
         * 至少有一个为空了，list1是否已经便利完 如果list1遍历完,则将point.next直接指向list2
         * 否则及list2遍历完，那么point.next直接指向list1
         **/
        point.next = list1 == null ? list2 : list1;

        return head.next;
    }

}
