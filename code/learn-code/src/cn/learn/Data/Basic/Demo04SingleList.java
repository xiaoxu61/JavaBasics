package cn.learn.Data.Basic;
/*
    创建链表
        实现链表的增删改查功能
*/

import java.util.Stack;

import static cn.learn.Data.Basic.SingleList.findLastIndexNode;
import static cn.learn.Data.Basic.SingleList.getLength;

public class Demo04SingleList {
    public static void main(String[] args) {
        //进行测试
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleList singleList = new SingleList();

        //添加节点,顺序位添加顺序
        /*singleList.add(hero1);
        singleList.add(hero2);
        singleList.add(hero3);
        singleList.add(hero4);*/
        //顺序按编号排列
        singleList.addByOrder(hero1);
        singleList.addByOrder(hero4);
        singleList.addByOrder(hero2);
        singleList.addByOrder(hero3);

        singleList.list();
        System.out.println();

        System.out.println("单链表反转测试");
        reversetList(singleList.getHead());
        singleList.list();
        System.out.println("逆序打印单链表");
        resversePrint(singleList.getHead());
        System.out.println();
        singleList.list();
        System.out.println();

        //修改节点
        HeroNode newHero = new HeroNode(2, "小卢", "玉麒麟~~");
        singleList.update(newHero);

        singleList.list();
        System.out.println();
        //删除一个节点
        singleList.delete(1);
        singleList.delete(4);

        singleList.list();
        //测试一下，求链表中有效节点的个数
        System.out.println(getLength(singleList.getHead()));

        //测试一下，看看是否得到了倒数第K个节点
        HeroNode res = findLastIndexNode(singleList.getHead(),3);
        System.out.println(res);

    }
    //从尾到头打印单链表
    //利用栈这个数据结构，将各个节点压入栈中，实现逆序打印
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
        //将栈中节点进行打印
        while (stack.size() > 0) {
            System.out.println(stack.pop());//栈的特点是先进后出
        }
    }


    //单链表的反转
    public static void reversetList(HeroNode head) {
        //如果当前列表位空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助的变量，帮助遍历原来链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点【cur】的下一个节点
        HeroNode reverseHead = new HeroNode(0, "","");
        //遍历原来链表，没遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        while (cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表最前端
            reverseHead.next = cur;//将cur连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next指向reverseHead，实现单链表的反转
        head.next = reverseHead.next;
    }
}

class SingleList {
    //初始化一个头节点
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加单项列表
    //思路当不考虑编号顺序时
    //找到当前链表的最后节点
    //将这个最后节点的next 指向 新的节点
    public void add(HeroNode h) {
        //因为head节点不能动
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没有找到
            temp = temp.next;
        }
        //当退出循环时，temp就指向了最后
        //将者节点的next指向新的节点
        temp.next = h;
    }

    public void addByOrder(HeroNode h) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针来帮助找到条件的位置
        HeroNode temp = head;
        //因为单链表，，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        Boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.NO > h.NO){
                //位置找到，就在temp的后面插入
                break;
            }else if(temp.next.NO == h.NO) {
                //说明希望添加的heroNode的编号依然存在
                flag = true;//编号存在
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的英雄编号%d已经存在，不能加入\n",h.NO);
        }else {
            //插入到链表中
            h.next = temp.next;
            temp.next = h;
        }

    }

    //修改节点的信息，根据NO编号来修改，即NO编号不能修改
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null){
                break;//链表已经遍历完
            }
            if (temp.NO == newHeroNode.NO) {
                //若找到对应编号信息，将标记改为true
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.printf("没有找到编号 %d 的节点，不能修改",newHeroNode.NO);
        }
    }

    //删除节点
    public void delete(int NO) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null){
                break;
            }
            if (temp.next.NO == NO) {
                //找到了待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //可删除
            temp.next = temp.next.next;
        }else {
            System.out.printf("删除的节点 %d 未找到\n", NO);
        }
    }
    //显示链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

    //查找单链表中的倒数第K个节点【新浪面试题】
    /*
        编写一个方法接收 head节点，同时接收一个index
        index 表示倒是第index个节点
        先把链表从头到尾遍历，得到链表的总长度
        得到长度后，我们从链表第一个开始遍历（size - index）个，就可以得到
        如果找到了，则返回改节点，否则返回null
    */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
//        第一个遍历得到链表的长度（节点个数）
        int size = getLength(head);
        //第二次遍历，size-index 位置，就是倒数的第k个节点
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义辅助变量
        HeroNode cur = head.next;
        for (int i = 0; i < size-index; i++) {
            cur = cur.next;
        }
        return cur;

    }

    //方法：获取到单链表的节点个数（如果是带头节点的链表，需求不统计头节点）
    /*
    * @param head 链表的头节点
    * @return 返回的就是有效节点个数
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
    public HeroNode next; //指向限一个节点

    //构造器
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