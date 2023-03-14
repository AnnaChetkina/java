
package OOP.homework;

import OOP.homework.heroes.*;

import java.util.*;

public class Program {
    static final int UNITS = 10;
    public static ArrayList<BaseHero> waitingList = new ArrayList<>();
    public static ArrayList<BaseHero> ligthSideTeam = new ArrayList<>();
    public static ArrayList<BaseHero> darkSideTeam = new ArrayList<>();
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        System.out.print("Press Enter to begin.");
        user_input.nextLine();
        createLightSide(ligthSideTeam, UNITS);
        createDarkSide(darkSideTeam, UNITS);
        createWaitingList(waitingList, ligthSideTeam, darkSideTeam);

        while (true){
            View.view();
            user_input.nextLine();
            for (BaseHero hero: waitingList) {
                if (ligthSideTeam.contains(hero)) hero.step(ligthSideTeam, darkSideTeam);
                else hero.step(darkSideTeam, ligthSideTeam);
            }
        }
    }

    public static void createHeroes() {
//        System.out.println("------------");
        createLightSide(ligthSideTeam, UNITS);
//        ligthSideTeam.forEach(n -> System.out.println(n.getInfo()));
//        System.out.println("------------");
        createDarkSide(darkSideTeam, UNITS);
//        darkSideTeam.forEach(n -> System.out.println(n.getInfo()));
        createWaitingList(waitingList, ligthSideTeam, darkSideTeam);
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

    private static List<BaseHero> createLightSide(List<BaseHero> team, int teamCount){
        // копейщик	арбалетчик монах Крестьянин
        Random rand = new Random();

//        List<BaseHero> team = new ArrayList<>();

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

    private static List<BaseHero> createDarkSide(List<BaseHero> team, int teamCount){
        // Крестьянин Разбойник	Снайпер	Колдун
        Random rand = new Random();

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

    private static List<BaseHero> createWaitingList(List<BaseHero> resList, List<BaseHero> l1, List<BaseHero> l2){
        resList = new ArrayList<>(l1);
        resList.addAll(l2);
        return resList;
    }


    private static String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }

}
