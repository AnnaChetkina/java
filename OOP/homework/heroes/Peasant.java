package OOP.homework.heroes;

public class Peasant extends BaseHero{
    public Peasant(String name, int hp) {
        super(name, hp);
    }

    public Peasant(String name) {
        super(name, Crossbowman.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("I am %s", super.getInfo());
    }

//    public void plowField(){
//        System.out.println(this.name + " plowed the field");
//    }
}
