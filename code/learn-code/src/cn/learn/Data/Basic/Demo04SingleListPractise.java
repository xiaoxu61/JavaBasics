package cn.learn.Data.Basic;
/*
    �ϲ���������ĵ������ϲ��Ժ���Ȼ����
*/

public class Demo04SingleListPractise {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(3, "¬����", "������");
        HeroNode hero3 = new HeroNode(5, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(7, "�ֳ�", "����ͷ");

        HeroNode hero5 = new HeroNode(2, "�ν�", "��ʱ��");
        HeroNode hero6 = new HeroNode(4, "¬����", "������");
        HeroNode hero7 = new HeroNode(6, "����", "�Ƕ���");
        HeroNode hero8 = new HeroNode(8, "�ֳ�", "����ͷ");

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
        System.out.println("����1Ϊ��");
        singleList.list();
        System.out.println("����2Ϊ");
        singleList1.list();
        System.out.println("�ϲ��������Ϊ");

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

        //����������Ϊ�գ��Ǿͷ���null
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
     * �ǵݹ��㷨---��
     */

    public static HeroNode mergeNoRecursion2(HeroNode node1, HeroNode node2) {
        // �ϲ�1��2
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }

        // head��¼�ϲ�������ı�ͷ(����бߵĴ���)
        HeroNode head = node1.NO <= node2.NO ? node1 : node2;

        // list1,list2������¼������ǰλ��
        HeroNode list1 = head == node1 ? node1 : node2;
        HeroNode list2 = head == node1 ? node2 : node1;

        // point����ָ��ϲ��������һ���ڵ�
        HeroNode point = head;
        list1 = list1.next;// ��ʼʱ�Ѿ�ָ����list1�ı�ͷ������ıȽ�list1Ҫ�ӵڶ�����ʼ

        // ʹ��ѭ������������������list1.data��list2.data�ıȽϽ��������point��һ�ڵ�
        while (list1 != null && list2 != null) {
            if (list1.NO <= list2.NO) {
                // list1.data <= list2.data ���ȸ���point����һ�ڵ�list1��Ȼ�����list1��λ��
                point.next = list1;
                list1 = list1.next;
            } else {
                // list1.data > list2.data ���ȸ���point����һ�ڵ�list2��Ȼ�����list2��λ��
                point.next = list2;
                list2 = list2.next;
            }
            // ����point��λ��Ϊ������һ�ڵ�
            point = point.next;
        }

        /*
         * ������һ��Ϊ���ˣ�list1�Ƿ��Ѿ������� ���list1������,��point.nextֱ��ָ��list2
         * ����list2�����꣬��ôpoint.nextֱ��ָ��list1
         **/
        point.next = list1 == null ? list2 : list1;

        return head.next;
    }

}
