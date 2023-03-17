package OOP.homework.heroes;

import java.util.List;

public class Warrior extends BaseHero{
    public Warrior(int attack, int defense, int maxDamage, int minDamage, int hp, int speed, String name, int x, int y) {
        super(attack, defense, maxDamage, minDamage, hp, speed, name, x, y);
    }
    public String getInfo() {
        return super.getInfo();
    }

    public boolean step(List<BaseHero> mySide, List<BaseHero> enemySide){
//        Если моя жизнь равна нулю, завершить обработку.
        if (this.state.equals("Die")) return false;

//      Поиск среди противников наиболее приближённого.
        BaseHero enemyTarget = this.findClosest(enemySide);
        if (enemyTarget == null) return true;

        //        Нанести повреждение найденному противнику, если до него 2 клетки.
        if (enemyTarget.point2D.getDistance(this.point2D) < 2){
            float damage = (enemyTarget.defense - attack) > 0 ? minDamage : (enemyTarget.defense - attack) < 0 ? maxDamage : (minDamage + maxDamage) / 2;
            enemyTarget.getDamage(damage);
        }
        //        иначе переместиться
        else {
            Point2D temp = this.point2D.chooseWay(enemyTarget.point2D);
            // шаг по вертикали
            if (Math.abs(temp.x) < Math.abs(temp.y)) {
                               if (this.point2D.chooseWay(enemyTarget.point2D).y > 0) this.point2D.y--;
                else this.point2D.y++;
            }
            // иначе шаг по горизонтали
            else {
                if (this.point2D.chooseWay(enemyTarget.point2D).x > 0) this.point2D.x--;
                else this.point2D.x++;
            }
        }
        return true;
    }
}


