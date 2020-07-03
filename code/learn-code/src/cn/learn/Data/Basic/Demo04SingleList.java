package cn.learn.Data.Basic;
/*
    ��������
        ʵ���������ɾ�Ĳ鹦��
*/

import java.util.Stack;

import static cn.learn.Data.Basic.SingleList.findLastIndexNode;
import static cn.learn.Data.Basic.SingleList.getLength;

public class Demo04SingleList {
    public static void main(String[] args) {
        //���в���
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "¬����", "������");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

        SingleList singleList = new SingleList();

        //��ӽڵ�,˳��λ���˳��
        /*singleList.add(hero1);
        singleList.add(hero2);
        singleList.add(hero3);
        singleList.add(hero4);*/
        //˳�򰴱������
        singleList.addByOrder(hero1);
        singleList.addByOrder(hero4);
        singleList.addByOrder(hero2);
        singleList.addByOrder(hero3);

        singleList.list();
        System.out.println();

        System.out.println("������ת����");
        reversetList(singleList.getHead());
        singleList.list();
        System.out.println("�����ӡ������");
        resversePrint(singleList.getHead());
        System.out.println();
        singleList.list();
        System.out.println();

        //�޸Ľڵ�
        HeroNode newHero = new HeroNode(2, "С¬", "������~~");
        singleList.update(newHero);

        singleList.list();
        System.out.println();
        //ɾ��һ���ڵ�
        singleList.delete(1);
        singleList.delete(4);

        singleList.list();
        //����һ�£�����������Ч�ڵ�ĸ���
        System.out.println(getLength(singleList.getHead()));

        //����һ�£������Ƿ�õ��˵�����K���ڵ�
        HeroNode res = findLastIndexNode(singleList.getHead(),3);
        System.out.println(res);

    }
    //��β��ͷ��ӡ������
    //����ջ������ݽṹ���������ڵ�ѹ��ջ�У�ʵ�������ӡ
    public static void resversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //��ջ�нڵ���д�ӡ
        while (stack.size() > 0) {
            System.out.println(stack.pop());//ջ���ص����Ƚ����
        }
    }


    //������ķ�ת
    public static void reversetList(HeroNode head) {
        //�����ǰ�б�λ�գ�����ֻ��һ���ڵ㣬���跴ת��ֱ�ӷ���
        if (head.next == null || head.next.next == null) {
            return;
        }
        //����һ�������ı�������������ԭ������
        HeroNode cur = head.next;
        HeroNode next = null;//ָ��ǰ�ڵ㡾cur������һ���ڵ�
        HeroNode reverseHead = new HeroNode(0, "","");
        //����ԭ������û����һ���ڵ㣬�ͽ���ȡ�����������µ�����reverseHead����ǰ��
        while (cur != null) {
            next = cur.next;//����ʱ���浱ǰ�ڵ����һ���ڵ㣬��Ϊ������Ҫʹ��
            cur.next = reverseHead.next;//��cur����һ���ڵ�ָ���µ�������ǰ��
            reverseHead.next = cur;//��cur���ӵ��µ�������
            cur = next;//��cur����
        }
        //��head.nextָ��reverseHead��ʵ�ֵ�����ķ�ת
        head.next = reverseHead.next;
    }
}

class SingleList {
    //��ʼ��һ��ͷ�ڵ�
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //��ӵ����б�
    //˼·�������Ǳ��˳��ʱ
    //�ҵ���ǰ��������ڵ�
    //��������ڵ��next ָ�� �µĽڵ�
    public void add(HeroNode h) {
        //��Ϊhead�ڵ㲻�ܶ�
        HeroNode temp = head;
        //���������ҵ����
        while (true) {
            if (temp.next == null) {
                break;
            }
            //���û���ҵ�
            temp = temp.next;
        }
        //���˳�ѭ��ʱ��temp��ָ�������
        //���߽ڵ��nextָ���µĽڵ�
        temp.next = h;
    }

    public void addByOrder(HeroNode h) {
        //��Ϊͷ�ڵ㲻�ܶ������������Ȼͨ��һ������ָ���������ҵ�������λ��
        HeroNode temp = head;
        //��Ϊ����������Ϊ�����ҵ�temp ��λ�� ���λ�õ�ǰһ���ڵ㣬������벻��
        Boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.NO > h.NO){
                //λ���ҵ�������temp�ĺ������
                break;
            }else if(temp.next.NO == h.NO) {
                //˵��ϣ����ӵ�heroNode�ı����Ȼ����
                flag = true;//��Ŵ���
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("׼�������Ӣ�۱��%d�Ѿ����ڣ����ܼ���\n",h.NO);
        }else {
            //���뵽������
            h.next = temp.next;
            temp.next = h;
        }

    }

    //�޸Ľڵ����Ϣ������NO������޸ģ���NO��Ų����޸�
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("����Ϊ��~~");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null){
                break;//�����Ѿ�������
            }
            if (temp.NO == newHeroNode.NO) {
                //���ҵ���Ӧ�����Ϣ������Ǹ�Ϊtrue
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.printf("û���ҵ���� %d �Ľڵ㣬�����޸�",newHeroNode.NO);
        }
    }

    //ɾ���ڵ�
    public void delete(int NO) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null){
                break;
            }
            if (temp.next.NO == NO) {
                //�ҵ��˴�ɾ���ڵ��ǰһ���ڵ�
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //��ɾ��
            temp.next = temp.next.next;
        }else {
            System.out.printf("ɾ���Ľڵ� %d δ�ҵ�\n", NO);
        }
    }
    //��ʾ����
    public void list() {
        if (head.next == null) {
            System.out.println("����Ϊ��");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            //����ڵ���Ϣ
            System.out.println(temp);
            //��temp����
            temp = temp.next;
        }
    }

    //���ҵ������еĵ�����K���ڵ㡾���������⡿
    /*
        ��дһ���������� head�ڵ㣬ͬʱ����һ��index
        index ��ʾ���ǵ�index���ڵ�
        �Ȱ������ͷ��β�������õ�������ܳ���
        �õ����Ⱥ����Ǵ������һ����ʼ������size - index�������Ϳ��Եõ�
        ����ҵ��ˣ��򷵻ظĽڵ㣬���򷵻�null
    */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
//        ��һ�������õ�����ĳ��ȣ��ڵ������
        int size = getLength(head);
        //�ڶ��α�����size-index λ�ã����ǵ����ĵ�k���ڵ�
        //����һ��index��У��
        if (index <= 0 || index > size) {
            return null;
        }
        //���帨������
        HeroNode cur = head.next;
        for (int i = 0; i < size-index; i++) {
            cur = cur.next;
        }
        return cur;

    }

    //��������ȡ��������Ľڵ����������Ǵ�ͷ�ڵ����������ͳ��ͷ�ڵ㣩
    /*
    * @param head �����ͷ�ڵ�
    * @return ���صľ�����Ч�ڵ����
    */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

}

class HeroNode{
    public int NO;
    public String name;
    public String nickName;
    public HeroNode next; //ָ����һ���ڵ�

    //������
    public HeroNode(int NO, String name, String nickName) {
        this.NO = NO;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "NO=" + NO +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}