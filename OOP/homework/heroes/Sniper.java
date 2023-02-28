package OOP.homework.heroes;

public class Sniper extends Shooter {
    int id;
    public Sniper(int attack, int defense, int shots, int maxDamage, int minDamage, int hp, int speed, String name) {
        super(attack, defense, shots, maxDamage, minDamage, hp, speed, name);
        this.id = super.getheroCnt();
    }

    public Sniper(String name) {
        this(12, 10,32, 10, 8, 15, 9, name);
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

//    public void shootBullet(){
//        System.out.println(this.name + " shoot a bullet");
//    }
}
