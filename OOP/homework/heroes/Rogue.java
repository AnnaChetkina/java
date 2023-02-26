package OOP.homework.heroes;

public class Rogue extends BaseHero{
    public Rogue(String name) {
        super(String.format(name + " #%d", ++Rogue.number),
                Rogue.r.nextInt(100, 200));
    }

    public Rogue() {
        super(String.format("Hero_Rogue #%d", ++Rogue.number),
                Rogue.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("%s", super.getInfo());
    }

    public void steal(){
        System.out.println(this.name + " stole something");
    }
}
