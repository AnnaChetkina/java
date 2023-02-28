package OOP.homework.heroes;

public class Monk extends Healer{
    int id; // todo спецификатор!
    public Monk(int attack, int defense, int maxDamage, int minDamage, int hp, int speed, int magic, String name) {
        super(attack, defense, maxDamage, minDamage, hp, speed, magic, name);
        this.id = super.getheroCnt();
    }

    public Monk(String name) {
        this(12, 7,-4, -4, 30, 5, 1, name);
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }
//    public void pray(){
//        System.out.println(this.name + " pray to God");
//    }
}
