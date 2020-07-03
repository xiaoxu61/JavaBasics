package cn.learn.ClassDefine;

/*
  ����һ���࣬����ģ�⡰ѧ��������
  ���ԣ���ʲô��
     ����
     ����
  ��Ϊ������ʲô��
     �Է�
     ˯��
     ѧϰ
  ��Ӧ��Jave���൱�У�

  ��Ա������
     String name
     int age
  ��Ա����
     public void eat(){}
     public void sleep(){}
     public void study(){}

ע�����
   1����Ա������ֱ�Ӷ������൱�У��ڷ������
   2����Ա������Ҫд��static�ؼ���

*/

public class Student{
    //��Ա����
    private int id;//ѧ��
    private static int idCounter = 0;//ѧ�ż�������ÿ��new��һ���¶����ʱ�򣬼�����++
    private String name; //����
    private int age;     //����
    private static String room;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getRoom() {
        return room;
    }

    public static void setRoom(String room) {
        Student.room = room;
    }

    public Student() {
        this.id = ++idCounter;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++idCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //��Ա����
    public void eat(){
        System.out.println("�Է�");
    }
    public void sleep(){
        System.out.println("˯��");
    }
    public void study(){
        System.out.println("Study");
    }


}

