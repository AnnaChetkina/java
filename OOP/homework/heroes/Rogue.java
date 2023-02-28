package OOP.homework.heroes;

public class Rogue extends Warrior{
    int id;
    public Rogue(int attack, int defense, int maxDamage, int minDamage, int hp, int speed, String name) {
        super(attack, defense, maxDamage, minDamage, hp, speed, name);
        this.id = super.getheroCnt();
    }

    public Rogue(String name) {
        this(8, 3, 4, 2 ,10 ,6, name);
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

//    public void steal(){
//        System.out.println(this.name + " stole something");
//    }
}
