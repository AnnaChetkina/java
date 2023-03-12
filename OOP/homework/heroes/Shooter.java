package OOP.homework.heroes;
//

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

    public int step(List<BaseHero> mySide, List<BaseHero> enemySide){
//        Если жизнь равна нулю или стрел нет, завершить обработку.
        if (this.hp <= 0 && this.shots <= 0) return 0;

//      Поиск среди противников наиболее приближённого.
        double minDistToEnemy = this.point2D.getDistance(enemySide.get(0).getPoint2D());
        int enemyTargetInd = 0;
//        System.out.println(minDistToEnemy);
        for (int i = 0; i < enemySide.size() ; i++){
            if (this.point2D.getDistance(enemySide.get(i).getPoint2D()) < minDistToEnemy) {
                minDistToEnemy = this.point2D.getDistance(enemySide.get(i).getPoint2D());
                enemyTargetInd = i;
            }
        }
//        System.out.println(minDistToEnemy + " " + enemyTargetInd);
        BaseHero enemyTarget = enemySide.get(enemyTargetInd);

//        Нанести среднее повреждение найденному противнику.
        enemyTarget.hp -= this.minDamage; // todo добавить формулы расчета среднего повреждения

//        Найти среди своих крестьянина.
        BaseHero myPeasant = null;
//        System.out.println(myPeasant);
        for (int i = 0; i < mySide.size() ; i++){
            if (mySide.get(i) instanceof Peasant) {
                myPeasant = mySide.get(i);
                System.out.println("found peasant "+ myPeasant.getName());

            }
        }
//        Если найден завершить метод иначе уменьшить запас стрел на одну.
        System.out.println("shots before shooter step " + this.shots);
        if (myPeasant != null) {
            this.shots -= 1;
            System.out.println("shots after shooter step " + this.shots);
        } else return 0;

        return 1;

    }
}
