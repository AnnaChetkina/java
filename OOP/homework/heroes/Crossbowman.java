package OOP.homework.heroes;

public class Crossbowman extends Shooter{
    private int id;
    public Crossbowman(int attack, int defense, int shots, int maxDamage, int minDamage, int hp, int speed, String name) {
        super(attack, defense, shots, maxDamage, minDamage, hp, speed, name);
        this.id = super.getheroCnt();
    }

    public Crossbowman(String name) {
            this(6, 3,16, 3, 2, 10, 4, name);
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

//    public void shootArrow(){
//        System.out.println(this.name + " fired an arrow");
//    }
}
