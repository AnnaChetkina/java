package OOP.homework.heroes;

public class Spearman extends BaseHero{
    int id;
    public Spearman(String name, int hp) {
        super(name, hp);
        this.id = super.getheroCnt();
    }

    public Spearman(String name) {
        super(name, Crossbowman.r.nextInt(100, 200));
        this.id = super.getheroCnt();
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

//    public void throwSpear(){
//        System.out.println(this.name + " threw a spear at someone");
//    }
}
