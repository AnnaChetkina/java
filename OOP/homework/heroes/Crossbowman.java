package OOP.homework.heroes;

public class Crossbowman extends BaseHero{
    public Crossbowman(String name) {
        super(String.format(name + " #%d", ++Crossbowman.number),
                Crossbowman.r.nextInt(100, 200));
    }

    public Crossbowman() {
        super(String.format("Hero_Crossbowman #%d", ++Crossbowman.number),
                Crossbowman.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("%s", super.getInfo());
    }

    public void shootArrow(){
        System.out.println(this.name + " fired an arrow");
    }
}
