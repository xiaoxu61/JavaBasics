package cn.learn.basic.Demo01;
/*
��������������person����ʱ���޷���ֹ����������鱻���ý���
�����������private�ؼ��ֽ���Ҫ�����ĳ�Ա������������

һ��ʹ����private�������Σ���ô�൱����Ȼ����������
���ǣ������˱��෶Χ֮��Ͳ���ֱ�ӷ�����

��ӷ���private��Ա���������Ƕ���һ�Զ�Getter/Setter����

�����getXxx����setXxx��������
����Getter��˵�������в���������ֵ���ͺͳ�Ա������Ӧ�������
��ӦSetter��˵�������з���ֵ���������ͺͳ�Ա������Ӧ��������

���ڻ������͵��е�booleaֵ��Getter����һ��Ҫд��isXxx����ʽ����setXxx���򲻱�
*/

public class Demo18Person {
    private String name;//����
    private int age;//����
    private boolean male; //�ǲ���ү��

    public void show(){
        System.out.println("�ҽ�" + name + "������" + age + "���ǲ���ү��" + male);
    }

    public void setMale(boolean b) {
        male = b;
    }

    public boolean isMale() {
        return male;
    }

    public void setName(String str) {
        name = str;
    }

    public String getName() {
        return name;
    }

    //�����Ա������ר��������age��������
    public void setAge(int num){
        if (num < 100 && num >= 9) {
            age = num;
        }else{
            System.out.println("���ݲ�����");
        }
    }

    //�����Ա������ר�Ż�ȡage������
    public int getAge(){
        return age;
    }
}
