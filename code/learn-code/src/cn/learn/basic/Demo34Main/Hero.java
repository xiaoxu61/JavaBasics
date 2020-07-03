package cn.learn.basic.Demo34Main;
//游戏当中的英雄角色类
public class Hero {

    private String name;//英雄名字
    private int age;//英雄年龄
    private Weapon weapon;//英雄武器
    private Skill skill;

    public void attack() {
        System.out.println("年龄为：" + age + "的" + name + ",拿着" + weapon.getCode());
    }

    public void attackSkill() {
        System.out.println(name + "使用技能");
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
