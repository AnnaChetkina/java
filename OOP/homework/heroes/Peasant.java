package OOP.homework.heroes;

public class Peasant extends BaseHero{
    int id;
    public Peasant(String name, int hp) {
        super(name, hp);
        this.id = super.getheroCnt();
    }

    public Peasant(String name) {
        super(name, Crossbowman.r.nextInt(100, 200));
        this.id = super.getheroCnt();
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

//    public void plowField(){
//        System.out.println(this.name + " plowed the field");
//    }
}
