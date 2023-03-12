package OOP.homework.heroes;

import java.util.List;

public class Peasant extends BaseHero{
    private int id;
    private int delivery;

    //    public Peasant(int attack, int defense, int maxDamage, int minDamage, int hp, int speed, int delivery, String name) {
    public Peasant(int delivery, String name, int x, int y) {
        super(1, 1, 1, 1, 1, 3, name, x, y);
        this.delivery = delivery;
        this.id = super.getheroCnt();
    }

    public Peasant(String name, int x, int y) {
        this(1, name, x, y);
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

    public int getId() {
        return this.id;
    }

    public void step(List<BaseHero> mySide, List<BaseHero> enemySide){
//        если не труп, то state = "Stand";
        if (!this.state.equals("Die")) this.state = "Stand";
    }
}
