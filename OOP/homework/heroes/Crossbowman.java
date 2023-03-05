package OOP.homework.heroes;

public class Crossbowman extends Shooter{
    private int id;
    private String side;
    public Crossbowman(int attack, int defense, int shots, int maxDamage, int minDamage, int hp, int speed, String name, int x, int y) {
        super(attack, defense, shots, maxDamage, minDamage, hp, speed, name, x, y);
        this.id = super.getheroCnt();
        this.side = "light";
    }

    public Crossbowman(String name, int x, int y) {
            this(6, 3,16, 3, 2, 10, 4, name, x, y);
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

    public String getSide() {
        return side;
    }

//    public void shootArrow(){
//        System.out.println(this.name + " fired an arrow");
//    }
}
