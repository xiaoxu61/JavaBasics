package cn.learn.basic.Demo16;
/*
    �����ȡ��Ա���������޸�ֵ
    Person���еĳ�Ա������String name
*/

import java.lang.reflect.Field;

public class Demo04Reflect {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("cn.learn.basic.Demo16.Person");
        Object obj = c.newInstance();
        //��ȡ��Ա����Class��ķ���getFields() class�ļ��е����й����ĳ�Ա����
        //����ֵ��Field[] Field��������Ա�����������
        /*Field[] fields = c.getFields();
        for(Field f : fields) {
            System.out.println(f);
        }*/
        //��ȡָ���ĳ�Ա����
        //Class��ķ�����getField(�����ַ������͵ı�����) ��ȡָ���ĳ�Ա����
        Field field = c.getField("name");
        System.out.println(field);
        //Field��ķ�����void set(Object obj, Object value) �޸ĳ�Ա������ֵ
        //Object obj�����ж����֧�֣� Object value �޸ĺ��ֵ
        field.set(obj, "����");
        System.out.println(obj);
    }
}
