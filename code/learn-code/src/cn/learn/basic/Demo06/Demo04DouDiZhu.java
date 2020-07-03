package cn.learn.basic.Demo06;
/*
    ���裺
        1�������
        2��ϴ��
        3������
        4������
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Demo04DouDiZhu {
    public static void main(String[] args) {
        //1�������
        //����Map���ϣ����Ǳ�ţ�ֵ����
        HashMap<Integer, String> pooker = new HashMap<>();
        //����List���ϣ��洢���
        ArrayList<Integer> pookerNumber = new ArrayList<>();
        //�����13����������
        String[] numbers = {"2", "A", "K","Q","J","10","9","8","7","6","5","4","3"};
        //�����ĸ���ɫ
        String[] colors = {"��", "��", "��", "÷"};
        //����һ������������Ϊ������
        int index = 2;
        //�������飬��ɫ�ӵ�������ϴ洢��Map����
        for(String number : numbers) {
            for (String clolor : colors) {
                pooker.put(index, clolor + number);
                pookerNumber.add(index);
                index++;
            }
        }
        System.out.println(pooker);
        System.out.println(pookerNumber);

        //�����洢������С��
        pooker.put(0, "����");
        pookerNumber.add(0);
        pooker.put(1, "С��");
        pookerNumber.add(1);

        //ϴ�ƣ����Ƶı�Ŵ���
        Collections.shuffle(pookerNumber);
        System.out.println(pookerNumber);

        //���ƹ��ܣ����Ʊ�ţ�������Ҽ��ϣ����Ƽ���
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();

        //���Ʋ��ü������� %3
        for (int i = 0; i < pookerNumber.size(); i++) {
            //������ȡģ�ж�
            //������������
            if (i >= pookerNumber.size() -3) {
                diPai.add(pookerNumber.get(i));
            }
            //������ %3 ȡģ���ֵ�����жϣ�Ȼ�󷢸����
            else if (i % 3 == 0) {
                player1.add(pookerNumber.get(i));
            }else if (i % 3 == 1) {
                player2.add(pookerNumber.get(i));
            }else if (i % 3 == 2) {
                player3.add(pookerNumber.get(i));
            }
        }
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(diPai);
        //���ƣ���������еı�ţ���Map�����в��ң����ݼ�ֵ����
        //����Ϊ����ʵ��
        look("���1", player1, pooker);
        look("���2", player2, pooker);
        look("���3", player3, pooker);
        look("ʣ��", diPai, pooker);
    }
    public static void look(String name, ArrayList<Integer> player, HashMap<Integer, String> pooker) {
        //����ArrayList���ϣ���ȡԪ�أ���Ϊ��ֵ��������Map����ֵ
        System.out.print(name + "���ƣ�[");
        for (Integer key : player) {
            String value = pooker.get(key);
            System.out.print(value + " ");
        }
        System.out.println("]");
    }
}
