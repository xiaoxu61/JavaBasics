package cn.learn.basic.Demo06;
/*
    步骤：
        1、组合拍
        2、洗牌
        3、发牌
        4、看牌
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Demo04DouDiZhu {
    public static void main(String[] args) {
        //1、组合拍
        //创建Map集合，键是编号，值是牌
        HashMap<Integer, String> pooker = new HashMap<>();
        //创建List集合，存储编号
        ArrayList<Integer> pookerNumber = new ArrayList<>();
        //定义出13点数的数组
        String[] numbers = {"2", "A", "K","Q","J","10","9","8","7","6","5","4","3"};
        //定义四个花色
        String[] colors = {"红", "黑", "方", "梅"};
        //定义一个整数变量作为键出现
        int index = 2;
        //遍历数组，花色加点数的组合存储到Map集合
        for(String number : numbers) {
            for (String clolor : colors) {
                pooker.put(index, clolor + number);
                pookerNumber.add(index);
                index++;
            }
        }
        System.out.println(pooker);
        System.out.println(pookerNumber);

        //单独存储大王和小王
        pooker.put(0, "大王");
        pookerNumber.add(0);
        pooker.put(1, "小王");
        pookerNumber.add(1);

        //洗牌，将牌的编号打乱
        Collections.shuffle(pookerNumber);
        System.out.println(pookerNumber);

        //发牌功能，将牌编号，发给玩家集合，底牌集合
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();

        //发牌采用集合所有 %3
        for (int i = 0; i < pookerNumber.size(); i++) {
            //对索引取模判断
            //将底牌先做好
            if (i >= pookerNumber.size() -3) {
                diPai.add(pookerNumber.get(i));
            }
            //对所有 %3 取模后的值进行判断，然后发给玩家
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
        //看牌，将玩家手中的编号，到Map集合中查找，根据键值查找
        //定义为方法实现
        look("玩家1", player1, pooker);
        look("玩家2", player2, pooker);
        look("玩家3", player3, pooker);
        look("剩下", diPai, pooker);
    }
    public static void look(String name, ArrayList<Integer> player, HashMap<Integer, String> pooker) {
        //遍历ArrayList集合，获取元素，作为键值，到集合Map中找值
        System.out.print(name + "的牌：[");
        for (Integer key : player) {
            String value = pooker.get(key);
            System.out.print(value + " ");
        }
        System.out.println("]");
    }
}
