package OOP.homework.heroes;

public class Monk extends Healer{
    int id;
    public Monk(String name, int hp) {
        super(name, hp);
        this.id = super.getheroCnt();
    }

    public Monk(String name) {
        super(name, Crossbowman.r.nextInt(100, 200));
        this.id = super.getheroCnt();
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }
//    public void pray(){
//        System.out.println(this.name + " pray to God");
//    }
}
