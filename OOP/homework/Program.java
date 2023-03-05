
package OOP.homework;

import OOP.homework.heroes.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        createHeroes();
    }

    public static void createHeroes(){
        System.out.println("------------");
        List<BaseHero> ligthSideTeam = createLightSide(10);
        ligthSideTeam.forEach(n -> System.out.println(n.getInfo()));
        System.out.println("------------");
        List<BaseHero> darkSideTeam = createDarkSide(10);
        darkSideTeam.forEach(n -> System.out.println(n.getInfo()));
        List<BaseHero> waitingList = getWaitingList(ligthSideTeam, darkSideTeam);
        System.out.println("------------");

        waitingList.sort(new HeroesComparator());

        waitingList.forEach(n -> System.out.println(n.getInfo() + " speed: " + n.getSpeed() + " hp: " + n.getHp()));

        System.out.println("------------");
        Crossbowman c = new Crossbowman(getName(), 0, 0);
        c.step(ligthSideTeam, darkSideTeam, "light");
        System.out.println("------------");
        Sniper s = new Sniper(getName(), 0, 0);
        s.step(ligthSideTeam, darkSideTeam, "light");

    }

    private static List<BaseHero> createLightSide(int teamCount){
        // копейщик	арбалетчик монах Крестьянин
        Random rand = new Random();

        List<BaseHero> team = new ArrayList<>();

        int initX = 0;
        int initY = 0;
        for (int i = 0; i < teamCount; i++) {
            int val = rand.nextInt(4);
            switch (val) {
                case 0: // Крестьянин
                    team.add(new Peasant(getName(), initX++, initY));
                    break;
                case 1:         // копейщик
                    team.add(new Spearman(getName(), initX++, initY));
                    break;
                case 2:         // арбалетчик
                    team.add(new Crossbowman(getName(), initX++, initY));
                    break;
                case 3:         // монах
                    team.add(new Monk(getName(), initX++, initY));
                    break;
                default:
                    break;
            }
        }
        return team;
    }

    private static List<BaseHero> createDarkSide(int teamCount){
        // Крестьянин Разбойник	Снайпер	Колдун
        Random rand = new Random();

        List<BaseHero> team = new ArrayList<>();

        int initX = 0;
        int initY = 9;

        for (int i = 0; i < teamCount; i++) {
            int val = rand.nextInt(4);
            switch (val) {
                case 0: // Крестьянин
                    team.add(new Peasant(getName(),  initX++, initY));
                    break;
                case 1:  // разбойник
                    team.add(new Rogue(getName(),  initX++, initY));
                    break;
                case 2:  // Снайпер
                    team.add(new Sniper(getName(),  initX++, initY));
                    break;
                case 3:         // колдун
                    team.add(new Sorcerer(getName(),  initX++, initY));
                    break;
                default:
                    break;
            }
        }
        return team;
    }

    private static List<BaseHero> getWaitingList(List<BaseHero> l1, List<BaseHero> l2){
        List<BaseHero> waitingList = new ArrayList<>(l1);
        waitingList.addAll(l2);
        return waitingList;
    }


    private static String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }

}
