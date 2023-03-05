package OOP.homework.heroes;

public class Rogue extends Warrior{
    private int id;
    public Rogue(int attack, int defense, int maxDamage, int minDamage, int hp, int speed, String name, int x, int y) {
        super(attack, defense, maxDamage, minDamage, hp, speed, name, x, y);
        this.id = super.getheroCnt();
    }

    public Rogue(String name, int x, int y) {
        this(8, 3, 4, 2 ,10 ,6, name, x, y);
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

//    public void steal(){
//        System.out.println(this.name + " stole something");
//    }
}
