package cn.learn.basic.Demo05;
/*
Map���ϵ�Ƕ�ף�Map�д洢�Ļ���Map����
Ҫ��
    ���ǲ���
        Java������
            001 ����
            002 ����
        Java��ҵ��
            001 ����
            002 ����
   ���������ݽ��ж���Ĵ洢
   001 ���� ��ֵ��
   �����ࣺ�洢ѧ�ź������ļ�ֵ��
   ��ҵ�ࣺ
   ���ǲ��ͣ��洢���ǰ༶

   ������Map <ѧ��, ����>
   ���ǲ���Map <�༶����, ������Map>
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo06MapMap {
    public static void main(String[] args) {
        //���������
        HashMap<String, String> javase = new HashMap<>();

        //�����ҵ��
        HashMap<String, String> javaee = new HashMap<>();
        //��ӻ�����
        javase.put("001", "����");
        javase.put("002", "����");
        //��Ӿ�ҵ��
        javaee.put("001", "����");
        javaee.put("002", "����");

        //���崫�ǲ��ͼ�������
        HashMap<String, HashMap<String, String>> java = new HashMap<>();
        java.put("������", javase);
        java.put("��ҵ��", javaee);

        //����
        keySet(java);
        System.out.println("=============");
    }

    public static void entrySet(HashMap<String, HashMap<String, String>> java) {
        //����java���Ϸ���entrySet�����������ϵļ�ֵ�Թ�ϵ���󣬴洢��Set����
        Set<Map.Entry<String, HashMap<String, String>>> big = java.entrySet();
        //��������������
        Iterator<Map.Entry<String, HashMap<String, String>>> it = big.iterator();

        while (it.hasNext()) {
            //it.next() ����ȡ�����ǣ�java���ϵļ�ֵ�Թ�ϵ����
            Map.Entry<String, HashMap<String, String>> map = it.next();
            //��map�����е�getKey��getValue����
            String key = map.getKey();
            Map<String, String> value = map.getValue();
            //�ظ�����������ȡ��ֵ�����HashMap����
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
        //���ü���czbk���Ϸ���keySet�����洢��Set����
        Set<String> className = czbk.keySet();
        //����Set����
        Iterator<String> classNameIt = className.iterator();
        while (classNameIt.hasNext()) {
            String classNameKey = classNameIt.next();
            //czbk���ϵķ�����ȡֵ,ֵ��HashMap�ļ���
            HashMap<String, String> classMap = czbk.get(classNameKey);
            //����classMap���ϵ��÷���keySet���洢��Set����
            Set<String> studentNum = classMap.keySet();
            Iterator<String> studentIt = studentNum.iterator();
            while (studentIt.hasNext()) {
                //studentIt.next()��ȡ��������classMap�ļ�������ѧ��
                String numKey = studentIt.next();
                String nameValue = classMap.get(numKey);
                System.out.println(classNameKey + ".." + numKey + ".^8^." + nameValue);
            }
        }
    }
}
