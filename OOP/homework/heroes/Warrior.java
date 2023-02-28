package OOP.homework.heroes;

public class Warrior extends BaseHero{
    public Warrior(int attack, int defense, int maxDamage, int minDamage, int hp, int speed, String name) {
        super(attack, defense, maxDamage, minDamage, hp, speed, name);
    }

//    public Warrior(String name) {
//        this(0, 0, 0, 0, 0, 0, name);
//    }

    public String getInfo() {
        return super.getInfo();
    }
}
