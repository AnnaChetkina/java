package OOP.homework.heroes;
//

import java.util.ArrayList;
import java.util.List;

public abstract class Shooter extends BaseHero{
    private int shots;
    public Shooter(int attack, int defense, int shots, int maxDamage, int minDamage, int hp, int speed, String name, int x, int y) {
        super(attack, defense, maxDamage, minDamage, hp, speed, name, x, y);
        this.shots = shots;
    }

    public String getInfo() {
       return super.getInfo();
    }

    public void step(List<BaseHero> mySide, List<BaseHero> enemySide){
//        Если жизнь равна нулю или стрел нет, завершить обработку.
        if (this.state.equals("Die") || this.shots <= 0) return;

//      Поиск среди противников наиболее приближённого.
        int enemyTargetInd = this.findClosest(enemySide);
        System.out.println("enemyTargetInd = " + enemyTargetInd);
        BaseHero enemyTarget = enemySide.get(enemyTargetInd);

//        Нанести среднее повреждение найденному противнику.
        float damage = (enemyTarget.defense - attack) > 0 ? minDamage : (enemyTarget.defense - attack) < 0 ? maxDamage : (minDamage + maxDamage) / 2;
        enemyTarget.getDamage(damage);

//        Найти среди своих крестьянина.
//        Если найден завершить метод иначе уменьшить запас стрел на одну.
        for (BaseHero hero: mySide) {
            if (hero instanceof Peasant && hero.state.equals("Stand")) {
                hero.state = "Busy";
                System.out.println("found peasant "+ hero.getName());
                return;
            }
        }
        this.shots--;
        System.out.println("shots after shooter step " + this.shots);
    }
}
