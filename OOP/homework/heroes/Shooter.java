package OOP.homework.heroes;
//

public abstract class Shooter extends BaseHero{
    private int shots;
    public Shooter(int attack, int defense, int shots, int maxDamage, int minDamage, int hp, int speed, String name) {
        super(attack, defense, maxDamage, minDamage, hp, speed, name);
        this.shots = shots;
    }

    public Shooter(String name) {
        this(0, 0, 0, 0, 0, 0,0, name);
    }

    public String getInfo() {
       return super.getInfo();
    }

}
