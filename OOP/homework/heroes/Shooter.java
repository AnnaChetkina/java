package OOP.homework.heroes;
//

import java.util.List;

public abstract class Shooter extends BaseHero{
    private int shots;
    private String side;
    public Shooter(int attack, int defense, int shots, int maxDamage, int minDamage, int hp, int speed, String name, int x, int y) {
        super(attack, defense, maxDamage, minDamage, hp, speed, name, x, y);
        this.shots = shots;
    }

    public String getInfo() {
       return super.getInfo();
    }

    public String getSide() {
        return side;
    }

    //    3.1 Если жизнь равна нулю или стрел нет, завершить оьработку. +
//            3.2 Поиск среди противников наиболее приближённого. +
// 3.3 Нанести среднее повреждение найденному противнику.
// 3.4 Найти среди своих крестьянина.
//            3.5 Если найден завершить метод иначе уменьшить запас стрел на одну.\
    public int step(List<BaseHero> side1, List<BaseHero> side2, String type){

//        Если жизнь равна нулю или стрел нет, завершить обработку.
        if (this.hp <= 0 && this.shots <= 0) return 0;

        List<BaseHero> mySide, enemySide;
        if (type == "light") {
            mySide = side1;
            enemySide = side2;
        } else {
            mySide = side2;
            enemySide = side1;
        }

//      Поиск среди противников наиболее приближённого.
        double minDistToEnemy = this.point2D.getDistance(enemySide.get(0).getPoint2D());
        int enemyTargetInd = 0;
        System.out.println(minDistToEnemy);
        for (int i = 0; i < enemySide.size() ; i++){
            if (this.point2D.getDistance(enemySide.get(i).getPoint2D()) < minDistToEnemy) {
                minDistToEnemy = this.point2D.getDistance(enemySide.get(i).getPoint2D());
                enemyTargetInd = i;
            }
        }
        System.out.println(minDistToEnemy + " " + enemyTargetInd);
        BaseHero enemyTarget = enemySide.get(enemyTargetInd);

//        Нанести среднее повреждение найденному противнику.
        enemyTarget.hp -= this.minDamage; // todo добавить формулы расчета среднего повреждения

//        Найти среди своих крестьянина.
        BaseHero myPeasant = null;
        System.out.println(myPeasant);
        for (int i = 0; i < mySide.size() ; i++){
            if (mySide.get(i) instanceof Peasant) {
                myPeasant = mySide.get(i);
            }
        }
//        Если найден завершить метод иначе уменьшить запас стрел на одну.
        System.out.println(this.shots);
        if (myPeasant != null) {
            this.shots -= 1;
            System.out.println(this.shots);
        } else return 0;

        return 1;

    }
}
