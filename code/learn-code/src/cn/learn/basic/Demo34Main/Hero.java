package cn.learn.basic.Demo34Main;
//��Ϸ���е�Ӣ�۽�ɫ��
public class Hero {

    private String name;//Ӣ������
    private int age;//Ӣ������
    private Weapon weapon;//Ӣ������
    private Skill skill;

    public void attack() {
        System.out.println("����Ϊ��" + age + "��" + name + ",����" + weapon.getCode());
    }

    public void attackSkill() {
        System.out.println(name + "ʹ�ü���");
        skill.use();
        System.out.println("over");
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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Hero(String name, int age, Weapon weapon, Skill skill) {
        this.name = name;
        this.age = age;
        this.weapon = weapon;
        this.skill = skill;
    }

    public Hero() {
    }
}
