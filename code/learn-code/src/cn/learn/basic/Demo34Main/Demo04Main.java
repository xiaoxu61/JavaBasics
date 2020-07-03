package cn.learn.basic.Demo34Main;

public class Demo04Main {

    public static void main(String[] args) {

        //创建一个英雄角色
        Hero hero = new Hero();
        //为英雄起名字
        hero.setName("盖伦");
        hero.setAge(20);

        //创建一个武器对象
        Weapon weapon = new Weapon("多兰剑");
        //为英雄配备武器
        hero.setWeapon(weapon);

        hero.attack();
        System.out.println("==============");

        Hero hero1 = new Hero();
        hero1.setName("艾希");

        //设置英雄技能
        hero1.setSkill(new SkillImpl());//使用单独定义的实现类
        hero1.attackSkill();
        System.out.println("====================");

//        还可以改成匿名内部类
        Skill skill = new Skill() {
            @Override
            public void use() {
                System.out.println("~~~~~~bong");
            }
        };
        hero1.setSkill(skill);
        hero1.attackSkill();
        System.out.println("========================");

        //进一步简化
        hero1.setSkill(new Skill() {
            @Override
            public void use() {
                System.out.println("!!!!biu");
            }
        });

        hero1.attackSkill();

    }
}
