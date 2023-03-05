package OOP.homework.heroes;

public abstract class Healer extends BaseHero {
    protected int magic;

    public Healer(int attack, int defense, int maxDamage, int minDamage, int hp, int speed,  int magic, String name,  int x, int y) {
        super(attack, defense, maxDamage, minDamage, hp, speed, name, x, y);
        this.magic = magic;
    }

    public String getInfo() {
        return super.getInfo();
    }
}
