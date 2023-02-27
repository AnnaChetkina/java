package OOP.homework.heroes;

public class Sniper extends Shooter {
    public Sniper(String name, int hp) {
        super(name, hp);
    }

    public Sniper(String name) {
        super(name, Sniper.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("I am %s", super.getInfo());
    }

//    public void shootBullet(){
//        System.out.println(this.name + " shoot a bullet");
//    }
}
