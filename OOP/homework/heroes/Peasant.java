package OOP.homework.heroes;

public class Peasant extends BaseHero{
    public Peasant(String name) {
        super(String.format(name + " #%d", ++Peasant.number),
                Peasant.r.nextInt(100, 200));
    }

    public Peasant() {
        super(String.format("Hero_Peasant #%d", ++Peasant.number),
                Peasant.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("%s", super.getInfo());
    }

    public void plowField(){
        System.out.println(this.name + " plowed the field");
    }
}
