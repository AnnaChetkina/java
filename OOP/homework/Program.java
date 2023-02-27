
package OOP.homework;

import OOP.homework.heroes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        createHeroes();
    }

    public static void createHeroes(){
        int teamCount = 10;
        Random rand = new Random();

        List<BaseHero> team = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            int val = rand.nextInt(4);
            switch (val) {
                case 0: // Крестьянин
                    team.add(new Peasant(getName()));
                    break;
                case 1:  // разбойник
                    team.add(new Rogue(getName()));
                    break;
                case 2:  // Снайпер
                    team.add(new Sniper(getName()));
                    break;
                case 3:         // колдун
                    team.add(new Sorcerer(getName()));
                    break;
                case 4:         // копейщик
                    team.add(new Spearman(getName()));
                    break;
                case 5:         // арбалетчик
                    team.add(new Crossbowman(getName()));
                    break;
                case 6:         // монах
                    team.add(new Monk(getName()));
                    break;
                default:
                    break;
            }
        }

        team.forEach(hero -> System.out.println(hero.getInfo()));
    }

    private static String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }

}
