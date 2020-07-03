package cn.learn.Data.Basic;
/*
    创建环形链表，解决约瑟夫问题
        根据用户输入，生成一个小孩的出圈顺序
        例如：n = 5 五个人
             k = 1，从第一个人开始报数
             m = 2 数2下
        1、需求创建一个辅助指针，helper，事先应该指向环形链表的h最后这个节点
            报数前，先让first和helper移动 k - 1次
        2、当小孩报数时，让first和helper指针同时移动 m - 1 次
        3、这时就可以将first指向的小孩节点出圈
            first = first.next
            helper.next = fist
            原来first指向的节点就没有任何引用，就会被回收

*/

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(5);
        list.showBoy();

        list.countBoy(1,2,5);
    }
}
/*
创建一个环形的单向链表
    单向环形列表的思路：
        先创建第一个节点，让First指向该节点，并形成环形
        后面当我们每创建一个新的节点，就把该节点，加入到已有的环形链表中即可

     遍历环形链表
        先让一个辅助指针，curBoy指向first节点
        然后通过while循环，遍历该环形链表即可 curBoy == first 结束
*/
class CircleSingleLinkedList{
    //创建一个first节点，当前无编号
    private Boy first = null;

    public void addBoy(int num) {
        //做一个校验
        if (num < 1){
            System.out.println("请输入大于1的节点数");
            return;
        }
        Boy curBoy = null;
        for(int i = 1; i <= num; i++) {
            //定义将添加的节点
            Boy boy = new Boy(i);
            //添加节点，头节点是不能动的
            if ( i == 1) {
                first = boy;
                boy.setNext(first);
                curBoy = boy;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空，没有Boy");
            return;
        }
        //first不能动，使用一个辅助指针
        Boy curBoy = first;
        while (true) {
            System.out.printf("Boy's number: %d\n" , curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    //根据用户的输入，计算出圈的顺序
    /*
        @ param starNo 表示从第几个小孩开始数数
        @ param countNum 表示数几下
        @ param nums 表示最初有多少个小孩在圈中
    */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo >nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建一个辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //将helper指针指向环的最后节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先将指针定位到指定位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (helper == first) {//说明圈中只剩一人
                break;
            }
            //让first与helper指针同时移动 countNum - 1次，然后出圈
            for(int i = 0; i < countNum -1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            //这时将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中小孩的编号%d\n",first.getNo());
    }
}
//创建boy类，表示一个节点
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
