package cn.learn.basic.Demo05;
/*
Map�ӿ�ʵ����Hashtable
�ײ����ݽ����ϣ���ص��HashMap��һ����
Hashtable �̰߳�ȫ���ϣ������ٶ���
HashMap�̲߳���ȫ���ϣ������ٶȿ�

Hashtable���˺�Vector��һ���ģ���JDK 1.2��ʼ�����Ƚ���HashMapȡ��
������������Properties��Ȼ��Ծ�ڿ�����̨

HashMap����洢nullֵ��null��
��Hashtable������(����ʱû�£�����ʱ���׳���ָ���쳣NullPointerException)

*/

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Demo04HashTable {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        Map<String, String> table = new Hashtable<>();
//        table.put(null, null);//
    }
}
