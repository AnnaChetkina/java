package OOP.homework.heroes;

public class Monk extends BaseHero{
    public Monk(String name) {
        super(String.format(name + " #%d", ++Monk.number),
                Monk.r.nextInt(100, 200));
    }

    public Monk() {
        super(String.format("Hero_Monk #%d", ++Monk.number),
                Monk.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("%s", super.getInfo());
    }

    public void pray(){
        System.out.println(this.name + " pray to God");
    }
}
