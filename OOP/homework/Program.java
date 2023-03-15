
package OOP.homework;

import OOP.homework.heroes.*;

import java.util.*;

public class Program {
    static final int UNITS = 10;
    public static ArrayList<BaseHero> allTeam = new ArrayList<>();
    public static ArrayList<BaseHero> holyTeam = new ArrayList<>();
    public static ArrayList<BaseHero> darkTeam = new ArrayList<>();

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        System.out.print("Press Enter to begin.");
        user_input.nextLine();
        createTeam(holyTeam, 0, 1);
        createTeam(darkTeam, 3, 10);
        allTeam.addAll(holyTeam);
        allTeam.addAll(darkTeam);
        sortTeam(allTeam);

        while (true){
            View.view();
            user_input.nextLine();
            for (BaseHero human: allTeam) {
                if (holyTeam.contains(human)) human.step(holyTeam, darkTeam);
                else human.step(darkTeam, holyTeam);
            }
        }
    }
    static void createTeam (ArrayList team, int offset, int posY) {
        for (int i = 0; i < UNITS; i++) {
            int rnd = new Random().nextInt(4)+offset;
            switch (rnd) {
                case (0):
                    team.add(new Sniper(getName(), i + 1, posY));
                    break;
                case (1):
                    team.add(new Rogue(getName(), i + 1, posY));
                    break;
                case (2):
                    team.add(new Sorcerer(getName(), i + 1, posY));
                    break;
                case (3):
                    team.add(new Peasant(getName(), i + 1, posY));
                    break;
                case (4):
                    team.add(new Crossbowman(getName(), i + 1, posY));
                    break;
                case (5):
                    team.add(new Monk(getName(), i + 1, posY));
                    break;
                case (6):
                    team.add(new Spearman(getName(), i + 1, posY));
                    break;
            }
        }
    }
    static void sortTeam (ArrayList<BaseHero> team){
        team.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero t0, BaseHero t1) {
                if (t1.getSpeed() == t0.getSpeed()) return (int) (t1.getHp() - t0.getHp());
                else  return (int) (t1.getSpeed() - t0.getSpeed());
            }
        });
    }
    static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length-1)]);
    }

}
