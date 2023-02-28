package OOP.homework.heroes;

public abstract class Healer extends BaseHero {
    protected int magic;

    public Healer(int attack, int defense, int maxDamage, int minDamage, int hp, int speed,  int magic, String name) {
        super(attack, defense, maxDamage, minDamage, hp, speed, name);
        this.magic = magic;
    }

    public Healer(String name) {
        this(0, 0, 0, 0, 0, 0, 0, name);
    }

    public String getInfo() {
        return super.getInfo();
    }
}
