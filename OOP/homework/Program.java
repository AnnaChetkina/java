// Крестьянин, разбойник, снайпер, колдун, копейщик, арбалетчик, монах. Для каждого сформировать список свойств и возможных действий.
// Напрнимер свойство скорость, действие нанести удар. Проанализировать получившиеся свойства и действия персонажей
// и создать Обобщённый класс описывающий свойства и действия имеющиеся у всех персонажей. Создать этот класс.
// Создать классы для каждого типа персонажей наследующие и расширяющие абстрактный(обобщённый) класс.
// В основной программе создать по одному экземпляру каждого типа персонажей.

package OOP.homework;

import OOP.homework.heroes.*;

public class Program {
    public static void main(String[] args) {
        createHeroes();
    }

    public static void createHeroes(){
        // Крестьянин
        Peasant peasant = new Peasant();
        System.out.println(peasant.getInfo());
        peasant.plowField();
        System.out.println("------");
        // Peasant
        Rogue rogue= new Rogue();
        System.out.println(rogue.getInfo());
        rogue.steal();
        System.out.println("------");
        int peasantDamage = rogue.Attack(peasant);
        System.out.printf("%s attacked %s with %d points", rogue.getName(), peasant.getName(), peasantDamage);
        System.out.println();
        peasant.GetHealed(10);
        System.out.println("Info about " + peasant.getName() + " after healing");
        System.out.println(peasant.getInfo());
        System.out.println("------");

        // Снайпер
        Sniper sniper = new Sniper();
        System.out.println(sniper.getInfo());
        sniper.shootBullet();
        System.out.println("------");

        // колдун
        Sorcerer sorcerer = new Sorcerer();
        System.out.println(sorcerer.getInfo());
        sorcerer.castSpell();
        System.out.println("------");

        // копейщик
        Spearman spearman = new Spearman();
        System.out.println(spearman.getInfo());
        spearman.throwSpear();
        System.out.println("------");

        // арбалетчик
        Crossbowman crossbowman = new Crossbowman();
        System.out.println(crossbowman.getInfo());
        crossbowman.shootArrow();
        System.out.println("------");

        // монах
        Monk monk = new Monk();
        System.out.println(monk.getInfo());
        monk.pray();
    }

}
