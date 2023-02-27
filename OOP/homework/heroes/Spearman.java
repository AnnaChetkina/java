package OOP.homework.heroes;

public class Spearman extends BaseHero{
    public Spearman(String name, int hp) {
        super(name, hp);
    }

    public Spearman(String name) {
        super(name, Crossbowman.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("I am %s", super.getInfo());
    }

//    public void throwSpear(){
//        System.out.println(this.name + " threw a spear at someone");
//    }
}
