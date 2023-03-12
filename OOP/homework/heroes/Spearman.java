package OOP.homework.heroes;

public class Spearman extends Warrior{
    private int id;
    public Spearman(int attack, int defense, int maxDamage, int minDamage, int hp, int speed, String name, int x, int y) {
        super(attack, defense, maxDamage, minDamage, hp, speed, name, x, y);
        this.id = super.getheroCnt();
    }

    public Spearman(String name, int x, int y) {
        this(4, 5, 3, 1 ,10 ,4, name, x, y);
    }
    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

}
