package cn.learn.Data.Basic;
/*
    ���������������Լɪ������
        �����û����룬����һ��С���ĳ�Ȧ˳��
        ���磺n = 5 �����
             k = 1���ӵ�һ���˿�ʼ����
             m = 2 ��2��
        1�����󴴽�һ������ָ�룬helper������Ӧ��ָ���������h�������ڵ�
            ����ǰ������first��helper�ƶ� k - 1��
        2����С������ʱ����first��helperָ��ͬʱ�ƶ� m - 1 ��
        3����ʱ�Ϳ��Խ�firstָ���С���ڵ��Ȧ
            first = first.next
            helper.next = fist
            ԭ��firstָ��Ľڵ��û���κ����ã��ͻᱻ����

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
����һ�����εĵ�������
    �������б��˼·��
        �ȴ�����һ���ڵ㣬��Firstָ��ýڵ㣬���γɻ���
        ���浱����ÿ����һ���µĽڵ㣬�ͰѸýڵ㣬���뵽���еĻ��������м���

     ������������
        ����һ������ָ�룬curBoyָ��first�ڵ�
        Ȼ��ͨ��whileѭ���������û��������� curBoy == first ����
*/
class CircleSingleLinkedList{
    //����һ��first�ڵ㣬��ǰ�ޱ��
    private Boy first = null;

    public void addBoy(int num) {
        //��һ��У��
        if (num < 1){
            System.out.println("���������1�Ľڵ���");
            return;
        }
        Boy curBoy = null;
        for(int i = 1; i <= num; i++) {
            //���彫��ӵĽڵ�
            Boy boy = new Boy(i);
            //��ӽڵ㣬ͷ�ڵ��ǲ��ܶ���
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

    //������ǰ��������
    public void showBoy() {
        if (first == null) {
            System.out.println("����Ϊ�գ�û��Boy");
            return;
        }
        //first���ܶ���ʹ��һ������ָ��
        Boy curBoy = first;
        while (true) {
            System.out.printf("Boy's number: %d\n" , curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    //�����û������룬�����Ȧ��˳��
    /*
        @ param starNo ��ʾ�ӵڼ���С����ʼ����
        @ param countNum ��ʾ������
        @ param nums ��ʾ����ж��ٸ�С����Ȧ��
    */
    public void countBoy(int startNo, int countNum, int nums) {
        //�ȶ����ݽ���У��
        if (first == null || startNo < 1 || startNo >nums) {
            System.out.println("����������������������");
            return;
        }
        //����һ������ָ�룬�������С����Ȧ
        Boy helper = first;
        //��helperָ��ָ�򻷵����ڵ�
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //С������ǰ���Ƚ�ָ�붨λ��ָ��λ��
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (helper == first) {//˵��Ȧ��ֻʣһ��
                break;
            }
            //��first��helperָ��ͬʱ�ƶ� countNum - 1�Σ�Ȼ���Ȧ
            for(int i = 0; i < countNum -1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("С��%d��Ȧ\n",first.getNo());
            //��ʱ��firstָ���С���ڵ��Ȧ
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("�������Ȧ��С���ı��%d\n",first.getNo());
    }
}
//����boy�࣬��ʾһ���ڵ�
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
