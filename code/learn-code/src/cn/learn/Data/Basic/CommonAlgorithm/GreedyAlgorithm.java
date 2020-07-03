package cn.learn.Data.Basic.CommonAlgorithm;
/*
    贪心算法：
        贪婪算法是指在对问题进行求解时，在每一步选择中都采取最好或者最优（最有利）的选择，从希望能够导致
    结果是最好或者最优的算法
        贪婪算法所得到的结果不一定是最优的结果（有时候会是最优解），但是都是相对近似（接近）最优解的结果
    集合覆盖问题-贪婪算法的思路分析：
        使用贪心算法，效率高
        目前并没有算法可以快速计算得到准备的值，使用贪心算法，则可以得到非常接近的解，并且效率高。选择策略
    上，因为需要覆盖全部地区的最小合集
        1、遍历所有的广播电台，找到一个覆盖了最多未覆盖的地区的电台（次电台可能包含一些覆盖的地区，但没有关系）
        2、将这个电台加入到一个集合中（比如ArrayList）想办法把该电台覆盖的地区在下次比较时去掉
        3、重复第一步直到覆盖了全部地球
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建广播电台，放入到Map
        HashMap<String, HashSet<String>> broadCasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("天津");
        hashSet4.add("上海");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map
        broadCasts.put("k1",hashSet1);
        broadCasts.put("k2",hashSet2);
        broadCasts.put("k3",hashSet3);
        broadCasts.put("k4",hashSet4);
        broadCasts.put("k5",hashSet5);

        //存放所有的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        allAreas.add("深圳");

        //创建ArrayList，存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时集合，在遍历过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖地区的交集
        HashSet<String> tempSet = new HashSet<>();

        //定义给maxKey，保存再一次遍历过程中，能够覆盖最大未覆盖的地区对应的电台的key
        //如果maxKey，不为null，则会加入到selects
        String maxKey = null;
        while (allAreas.size() != 0) {//如果allAreas不为0，则表示还没有覆盖到所有的地区
            //没进行一次while，需要
            maxKey = null;

            //遍历broadcast，取出对应的key
            for (String key : broadCasts.keySet()) {
                //没进行一次for
                tempSet.clear();

                //当前这个key能够覆盖的地区
                HashSet<String> areas = broadCasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet 和 allAreas 集合的交集，交集会赋给tempSet
                tempSet.retainAll(allAreas);//保留共有的部分的集合，交给tempSet
                //如果当前集合包含的未覆盖地区的数量，比maxKey指向的集合地区还多
                //就需要重置maxKey
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadCasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            //maxKey != null, 就应该将maxKey加入到selects
            if (maxKey != null) {
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区从allAreas去掉
                allAreas.removeAll(broadCasts.get(maxKey));
            }
        }

        System.out.println("得到的结果" + selects);

    }
}
