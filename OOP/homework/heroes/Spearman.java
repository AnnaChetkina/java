package OOP.homework.heroes;

public class Spearman extends BaseHero{
    private int id;
    public Spearman(int attack, int defense, int maxDamage, int minDamage, int hp, int speed, String name) {
        super(attack, defense, maxDamage, minDamage, hp, speed, name);
        this.id = super.getheroCnt();
    }

    public Spearman(String name) {
        this(4, 5, 3, 1 ,10 ,4, name);
    }
    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

//    public void throwSpear(){
//        System.out.println(this.name + " threw a spear at someone");
//    }
}
