package cn.learn.basic.Demo05;
/*
Map集合的嵌套，Map中存储的还是Map集合
要求：
    传智播客
        Java基础班
            001 张三
            002 李四
        Java就业班
            001 王五
            002 赵六
   对以上数据进行对象的存储
   001 张三 键值对
   基础班：存储学号和姓名的键值对
   就业班：
   传智播客：存储的是班级

   基础班Map <学号, 姓名>
   传智播客Map <班级名字, 基础班Map>
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo06MapMap {
    public static void main(String[] args) {
        //定义基础班
        HashMap<String, String> javase = new HashMap<>();

        //定义就业班
        HashMap<String, String> javaee = new HashMap<>();
        //添加基础班
        javase.put("001", "张三");
        javase.put("002", "李四");
        //添加就业班
        javaee.put("001", "王五");
        javaee.put("002", "赵六");

        //定义传智播客集合容器
        HashMap<String, HashMap<String, String>> java = new HashMap<>();
        java.put("基础班", javase);
        java.put("就业班", javaee);

        //遍历
        keySet(java);
        System.out.println("=============");
    }

    public static void entrySet(HashMap<String, HashMap<String, String>> java) {
        //调用java集合方法entrySet方法，将集合的键值对关系对象，存储到Set集合
        Set<Map.Entry<String, HashMap<String, String>>> big = java.entrySet();
        //迭代器迭代集合
        Iterator<Map.Entry<String, HashMap<String, String>>> it = big.iterator();

        while (it.hasNext()) {
            //it.next() 方法取出的是，java集合的键值对关系对象
            Map.Entry<String, HashMap<String, String>> map = it.next();
            //用map方法中的getKey与getValue方法
            String key = map.getKey();
            Map<String, String> value = map.getValue();
            //重复上述动作，取出值里面的HashMap对象
            Set<Map.Entry<String, String>> small = value.entrySet();
            Iterator<Map.Entry<String, String>> iterator = small.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> map1 = iterator.next();
                String key1 = map1.getKey();
                String value1 = map1.getValue();
                System.out.println(key + "..." + key1 + "***" + value1);
            }
        }
    }

    public static void keySet(HashMap<String, HashMap<String, String>> czbk) {
        //调用集合czbk集合方法keySet将键存储到Set集合
        Set<String> className = czbk.keySet();
        //迭代Set集合
        Iterator<String> classNameIt = className.iterator();
        while (classNameIt.hasNext()) {
            String classNameKey = classNameIt.next();
            //czbk集合的方法获取值,值是HashMap的集合
            HashMap<String, String> classMap = czbk.get(classNameKey);
            //调用classMap集合调用方法keySet，存储到Set集合
            Set<String> studentNum = classMap.keySet();
            Iterator<String> studentIt = studentNum.iterator();
            while (studentIt.hasNext()) {
                //studentIt.next()获取出来的是classMap的键，就是学号
                String numKey = studentIt.next();
                String nameValue = classMap.get(numKey);
                System.out.println(classNameKey + ".." + numKey + ".^8^." + nameValue);
            }
        }
    }
}
