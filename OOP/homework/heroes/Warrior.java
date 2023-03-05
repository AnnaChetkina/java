package OOP.homework.heroes;

public class Warrior extends BaseHero{
    public Warrior(int attack, int defense, int maxDamage, int minDamage, int hp, int speed, String name, int x, int y) {
        super(attack, defense, maxDamage, minDamage, hp, speed, name, x, y);
    }

    public String getInfo() {
        return super.getInfo();
    }
}
