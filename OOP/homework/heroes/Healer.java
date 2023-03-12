package OOP.homework.heroes;

import java.util.List;

public abstract class Healer extends BaseHero {
    protected int magic;

    public Healer(int attack, int defense, int maxDamage, int minDamage, int hp, int speed,  int magic, String name,  int x, int y) {
        super(attack, defense, maxDamage, minDamage, hp, speed, name, x, y);
        this.magic = magic;
    }

    public String getInfo() {
        return super.getInfo();
    }


    public void step(List<BaseHero> mySide, List<BaseHero> enemySide){
//       пробежаться по всем своим, если среди своих встретился первый попавшийся с повреждением
//       (здоровье меньше максимального), его надо вылечить.
        if (this.state.equals("Die") || this.magic <= 0) return;

        for (BaseHero hero: mySide) {
//            System.out.println(hero.hp + "/" + hero.maxHp);
            if (!hero.state.equals("Die") && hero.hp < hero.maxHp) {
                hero.getHealed(this.magic);
                System.out.println("heal "
                        + hero.getClass().getSimpleName()
                        + " " + hero.getName()
                        + "; hp after healing = " + hero.getHp()
                        + "; state = " + hero.getState()
                );
                this.magic--;
                return;
            }
        }

    }
}
