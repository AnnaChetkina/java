package OOP.homework.heroes;

public class Sorcerer extends Healer{
    private int id;

    public Sorcerer(int attack, int defense, int maxDamage, int minDamage, int hp, int speed,  int magic, String name) {
        super(attack, defense, maxDamage, minDamage, hp, speed, magic, name);
        this.id = super.getheroCnt();
    }

    public Sorcerer(String name) {
        this(17, 12,-5, -5, 30, 9, 1, name);
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }
//    public void castSpell(){
//        System.out.println(this.name + " cast a spell");
//    }
}

