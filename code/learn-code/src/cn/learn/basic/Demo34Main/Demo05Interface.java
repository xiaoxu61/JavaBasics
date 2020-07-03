package cn.learn.basic.Demo34Main;


import java.util.ArrayList;
import java.util.List;

public class Demo05Interface {

    public static void main(String[] args) {
        //左边是接口名称，右边是实现类名称，这就是多态写法
        List<String> list = new ArrayList<>();

        List<String> result  = addName(list);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static List<String> addName(List<String> list)  {
        list.add("迪丽热巴");
        list.add("迪丽热");
        list.add("迪丽");
        list.add("迪lili");
        return list;
    }

}
