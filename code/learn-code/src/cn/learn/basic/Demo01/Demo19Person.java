package cn.learn.basic.Demo01;
/*
�������ľֲ���������ĳ�Ա��������ʱ�����ݾͽ�ԭ������ʹ�þֲ�����
�����Ҫ���ʱ��෽���еĳ�Ա��������Ҫʹ�ø�ʽ
this.��Ա������

"ͨ��˭���õķ����������this"

һ����׼����ͨ��Ҫӵ�������ĸ���ɲ���
1�����еĳ�Ա������Ҫʹ��private�ؼ�������
2��Ϊÿһ����Ա������дһ��Getter/Setter����
3����дһ���޲����Ĺ��췽��
4����дһ��ȫ�����Ĺ��췽��

������׼����Ҳ����Java Bean

*/

public class Demo19Person {
    String name;//����
    String name1;//��һ������������
    private String name2;
    private int age;

    //�����ǶԷ�������
    //name���Լ�������
    public void sayHello(String who){
        System.out.println(who + "����ã�����" + name);
    }

    public void SayHello(String name1){

        System.out.println(name1 + "����ã�����" + name1);
        System.out.println(name1 + "����ã�����" + this.name1);

        System.out.println(this);
    }
    //�޲������췽��
    public Demo19Person(){
        System.out.println("�޲������췽��ִ����!");
    }
    //ȫ�������췽��
    public Demo19Person(String name2, int age){
        System.out.println("�в������췽��ִ����!");
        this.name2 = name2;
        this.age = age;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName2() {
        return name2;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
