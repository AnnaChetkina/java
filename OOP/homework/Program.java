
package OOP.homework;

import OOP.homework.heroes.*;

import java.util.*;

public class Program {
    static final int UNITS = 10;
    public static void main(String[] args) {
        createHeroes();
    }

    public static void createHeroes() {
//        System.out.println("------------");
        List<BaseHero> ligthSideTeam = createLightSide(UNITS);
//        ligthSideTeam.forEach(n -> System.out.println(n.getInfo()));
//        System.out.println("------------");
        List<BaseHero> darkSideTeam = createDarkSide(UNITS);
//        darkSideTeam.forEach(n -> System.out.println(n.getInfo()));
        List<BaseHero> waitingList = getWaitingList(ligthSideTeam, darkSideTeam);
//        System.out.println("------------");

        waitingList.sort(new HeroesComparator());

        waitingList.forEach(n -> System.out.println(n.getInfo() + " speed: " + n.getSpeed() + " hp: " + n.getHp()));

        System.out.println("------------");

        Scanner sc = new Scanner(System.in);
        String stop = "";
        while (stop.equals("")) {
            System.out.println("*******");
            for (BaseHero hero : waitingList) {
                if (ligthSideTeam.contains(hero)) {
                    System.out.println("lightSide" + ": " + hero.getInfo());
                    hero.step(ligthSideTeam, darkSideTeam);
                    System.out.println("hp = " + hero.getHp() + " state = " + hero.getState());
                    System.out.println("------------");
                } else {
                    System.out.println("darkSide" + ": " + hero.getInfo());
                    hero.step(darkSideTeam, ligthSideTeam);
                    System.out.println(" hp = " + hero.getHp() + " state = " + hero.getState());
                    System.out.println("------------");
                }
            }
            stop = sc.nextLine();
        }
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
