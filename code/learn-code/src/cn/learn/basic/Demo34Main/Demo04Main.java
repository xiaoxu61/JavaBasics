package cn.learn.basic.Demo34Main;

public class Demo04Main {

    public static void main(String[] args) {

        //����һ��Ӣ�۽�ɫ
        Hero hero = new Hero();
        //ΪӢ��������
        hero.setName("����");
        hero.setAge(20);

        //����һ����������
        Weapon weapon = new Weapon("������");
        //ΪӢ���䱸����
        hero.setWeapon(weapon);

        hero.attack();
        System.out.println("==============");

        Hero hero1 = new Hero();
        hero1.setName("��ϣ");

        //����Ӣ�ۼ���
        hero1.setSkill(new SkillImpl());//ʹ�õ��������ʵ����
        hero1.attackSkill();
        System.out.println("====================");

//        �����Ըĳ������ڲ���
        Skill skill = new Skill() {
            @Override
            public void use() {
                System.out.println("~~~~~~bong");
            }
        };
        hero1.setSkill(skill);
        hero1.attackSkill();
        System.out.println("========================");

        //��һ����
        hero1.setSkill(new Skill() {
            @Override
            public void use() {
                System.out.println("!!!!biu");
            }
        });

        hero1.attackSkill();

    }
}
