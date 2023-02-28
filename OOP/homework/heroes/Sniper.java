package OOP.homework.heroes;

public class Sniper extends Shooter {
    int id;
    public Sniper(String name, int hp) {
        super(name, hp);
        this.id = super.getheroCnt();
    }

    public Sniper(String name) {
        super(name, Sniper.r.nextInt(100, 200));
        this.id = super.getheroCnt();
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

//    public void shootBullet(){
//        System.out.println(this.name + " shoot a bullet");
//    }
}
