package cn.learn.basic.Demo33Final;
/*
���ڳ�Ա������˵�����ʹ��final�ؼ������Σ���ô�������Ҳ�����ǲ��ɱ�

1�����ڳ�Ա��������Ĭ��ֵ����������final֮������ֶ���ֵ�������ٸ�Ĭ��ֵ��
2������final��Ա������Ҫôʹ��ֱ�Ӹ�ֵ��Ҫôͨ�����췽����ֵ������ѡ��һ
3�����뱣֤�൱�����е����ع��췽���������ջ��final�ĳ�Ա�������и�ֵ
*/

public class Person {
    private final String name/* = "¹��"*/;

    public String getName() {
        return name;
    }

    public void setName(String name) {
//        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {
        name = "����ͮ";
    }
}
