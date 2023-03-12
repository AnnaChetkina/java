package OOP.homework.heroes;

public class Sorcerer extends Healer{
    private int id;

    public Sorcerer(int attack, int defense, int maxDamage, int minDamage, int hp, int speed,  int magic, String name, int x, int y) {
        super(attack, defense, maxDamage, minDamage, hp, speed, magic, name, x, y);
        this.id = super.getheroCnt();
    }

    public Sorcerer(String name, int x, int y) {
        this(17, 12,-5, -5, 30, 9, 1, name, x, y);
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

}

