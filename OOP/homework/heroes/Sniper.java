package OOP.homework.heroes;

public class Sniper extends BaseHero{
    public Sniper(String name) {
        super(String.format(name + " #%d", ++Sniper.number),
                Sniper.r.nextInt(100, 200));
    }

    public Sniper() {
        super(String.format("Hero_Sniper #%d", ++Sniper.number),
                Sniper.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("%s", super.getInfo());
    }

    public void shootBullet(){
        System.out.println(this.name + " shoot a bullet");
    }
}
