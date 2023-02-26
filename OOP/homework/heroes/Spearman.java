package OOP.homework.heroes;

public class Spearman extends BaseHero{
    public Spearman(String name) {
        super(String.format(name + " #%d", ++Spearman.number),
                Spearman.r.nextInt(100, 200));
    }

    public Spearman() {
        super(String.format("Hero_Spearman #%d", ++Spearman.number),
                Spearman.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("%s", super.getInfo());
    }

    public void throwSpear(){
        System.out.println(this.name + " threw a spear at someone");
    }
}
