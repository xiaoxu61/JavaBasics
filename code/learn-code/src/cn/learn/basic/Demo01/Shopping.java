package cn.learn.basic.Demo01;

import java.util.ArrayList;
import java.util.Scanner;

/*
  ʵ�ֿ���������
     1���洢��Ʒ��Ϣ
       ���������ϣ��洢��Ʒ���ͱ���
       ����Ʒ���͵ı������洢��������
     2���鿴����嵥
        �����Ͻ��б�������ȡ�������е�Goods���ͱ���
        ���ÿһ��Goods���͵�����
        ������ͣ��ܿ�棬�ܽ��
     3���޸���Ʒ�Ŀ��
       �������ϣ���ȡ�������д洢��Goods���ͱ���
       ��������Goods�������count��ֵ�����޸ģ��������룩
 */
public class Shopping {
    public static void main(String[] args){
      //����ArrayList���ϣ��洢Goods����
      ArrayList<Goods> array = new ArrayList<Goods>();
      //���������Ʒ��Ϣ�ķ���
      addGoods(array);
      //������ѭ����
      while (true){
          //����ѡ���ܵķ�������ȡ���û�����Ĺ������
          int number = chooseFunction();
          //������ж�
          switch (number){
              case 1:
                  //����鿴���
                  printStore(array);
                  break;
              case 2:
                  //�����޸Ŀ��
                  update(array);
                  break;
              case 3:
                  return;
              default:
                  System.out.println("�޴˹���");
          }
      }
    }
    /*
       ���巽����ʵ��ѡ��˵����û����ݹ���ѡ��˵�
     */
    public static int chooseFunction(){
        System.out.println("------������-----");
        System.out.println("1���鿴����嵥");
        System.out.println("2���޸Ŀ������");
        System.out.println("3���˳�");
        System.out.println("��������Ҫִ�еĲ������");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        return number;
    }
    /*
       ���巽�����޸Ŀ��
       �������룬��goods�е�����ֵ���޸�
     */
    public static void update(ArrayList<Goods> array){
        Scanner sc = new Scanner(System.in);
        //�������ϣ���ȡ�����е�ÿ��Ԫ��
        for(int i = 0; i < array.size(); i++){
            //���Ϸ���get��ȡ���Ǽ��ϵ�Ԫ�أ�Ԫ������Goods
            Goods g = array.get(i);
            System.out.println("������"+g.brand+"�Ŀ����");
            //Goods���ԣ�count�����޸�
            g.count = sc.nextInt();
        }
    }
    /*
       ���巽�����鿴����嵥����������
     */
    public static void printStore(ArrayList<Goods> array){
        System.out.println("-------�̳�����嵥------");
        System.out.println("Ʒ���ͺ�     �ߴ�    �۸�    �����");
        //��������������ܿ����
        int totalCount = 0;
        double totalMoney = 0;
        //��������
        for(int i = 0; i < array.size(); i++){
            Goods g = array.get(i);
            System.out.println(g.brand+"    "+g.size+"    "+g.price+"    "+g.count);
            totalCount = totalCount+g.count;
            totalMoney = totalMoney+g.count*g.price;
        }
        System.out.println("���������"+totalCount);
        System.out.println("����ܽ�"+totalMoney);

    }
    /*
      ���弯�Ϸ���������Ʒ����Ϣ�洢��������
      ���������з����Ĺ������ݣ���������
     */
    public static void addGoods(ArrayList<Goods> array){
        //������Ʒ���ͱ���Good���͵ı���
        Goods g1 = new Goods();
        Goods g2 = new Goods();
        g1.brand = "MacBook";
        g1.price = 999.99;
        g1.count = 3;

        g2.brand = "TinkPad";
        g2.price = 5555.32;
        g2.count = 2;

        array.add(g1);
        array.add(g2);
    }
}
