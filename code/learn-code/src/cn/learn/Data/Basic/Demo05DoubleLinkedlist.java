package cn.learn.Data.Basic;
/*
    ˫�������ʵ��
    ����˫������ı�������ӡ��޸ġ�ɾ����
    1����������͵�����һ����ֻ�ǿ�����ǰ��Ҳ����������
    2����ӣ�Ĭ����ӵ�˫����������
        a�����ҵ�˫��������������ڵ�
        b��temp.next = newNode
        c��newNode.pre = temp
    3���޸ĵ�˼·��ԭ���뵥����һ��
    4��ɾ��
        a����Ϊ��˫��������ˣ�����ʵ������ɾ��ĳ���ڵ�
        b��ֱ���ҵ�Ҫɾ��������ڵ㣬����temp
            temp.pre.next = temp.next
            temp.next.pre = temp.pre
*/

public class Demo05DoubleLinkedlist {
    public static void main(String[] args) {
        DoubleLinkedlist list = new DoubleLinkedlist();
        newHeroNode hero1 = new newHeroNode(1, "�ν�", "��ʱ��");
        newHeroNode hero2 = new newHeroNode(2, "¬����", "������");
        newHeroNode hero3 = new newHeroNode(3, "����", "�Ƕ���");
        newHeroNode hero4 = new newHeroNode(4, "�ֳ�", "����ͷ");
        //��ӵ�������
        /*list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.add(hero4);*/
        //��˳�����
        list.addOrder(hero1);
        list.addOrder(hero4);
        list.addOrder(hero3);
        list.addOrder(hero2);
        list.list();
        /*list.list();
        System.out.println("�޸ĺ������");
        newHeroNode hero5 = new newHeroNode(4, "��", "����ͷ~~");
        list.update(hero5);
        list.list();
        System.out.println("ɾ���������");
        list.delete(4);
        list.list();*/
    }
}
class DoubleLinkedlist{
    private newHeroNode head = new newHeroNode(0, "", "");

    public newHeroNode getHead() {
        return head;
    }
    //��ӽڵ�,�ڽڵ�β�����
    public void add(newHeroNode node) {

        newHeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //ѭ���˳���ָ���µĽڵ�
        //�γ�˫������
        temp.next = node;
        node.pre = temp;
    }

    //���ձ��˳�����˫������
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
            System.out.println("��Ҫ��ӵ�Ӣ���Ѵ���");
        }else{

            if (temp.next != null) {//����������β��������˲���
                hero.next = temp.next;
            }
            temp.next = hero;
            hero.pre = temp;
        }
    }

    //�޸�˫������
    public void update(newHeroNode hero){
        if (head.next == null) {
            System.out.println("����Ϊ��~�޷��޸�");
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
            System.out.printf("δƥ�䵽��Ҫ�޸ı��%d",hero.no);
        }
    }

    //��˫�������У�ɾ��һ���ڵ�
    //����˫������ֱ���ҵ���Ҫɾ���ڵ㣬�ҵ���ֱ��ɾ��
    public void delete(int no){
        if (head.next == null) {
            System.out.println("����Ϊ��~~�޷�ɾ��");
            return;
        }

        newHeroNode temp = head.next;
        boolean flag =false;
        while (true) {
            if (temp == null) {//�������������ѭ��
                break;
            }
            if (temp.no == no) {//�ҵ���ɾ��ѡ�����ѭ��
                flag = true;
                break;
            }
            temp = temp.next;//temp���ƣ�����
        }
        if (flag) {
            temp.pre.next = temp.next;
            //���ɾ���������һ���ڵ㣬����Ҫִ���������䣬�������ֿ�ָ���쳣
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("δ�ҵ���ɾ���ڵ�"+no);
        }
    }
    //����˫������
    public void list() {
        if (head.next == null){
            System.out.println("����Ϊ��~~");
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

//��������
class newHeroNode{
    public int no;
    public String name;
    public String nickName;
    public newHeroNode next;//ָ����һ���ڵ�
    public newHeroNode pre;//ָ��ǰһ���ڵ�

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