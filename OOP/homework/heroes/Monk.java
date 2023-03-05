package OOP.homework.heroes;

public class Monk extends Healer{
    private int id;
    public Monk(int attack, int defense, int maxDamage, int minDamage, int hp, int speed, int magic, String name, int x, int y) {
        super(attack, defense, maxDamage, minDamage, hp, speed, magic, name, x, y);
        this.id = super.getheroCnt();
    }

    public Monk(String name, int x, int y) {
        this(12, 7,-4, -4, 30, 5, 1, name, x, y);
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }
//    public void pray(){
//        System.out.println(this.name + " pray to God");
//    }
}
