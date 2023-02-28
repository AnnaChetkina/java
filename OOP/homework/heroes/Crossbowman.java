package OOP.homework.heroes;

public class Crossbowman extends Shooter{
    int id;
    public Crossbowman(String name, int hp) {
        super(name, hp);
        this.id = super.getheroCnt();
    }

    public Crossbowman(String name) {
        super(name, Crossbowman.r.nextInt(100, 200));
        this.id = super.getheroCnt();
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

//    public void shootArrow(){
//        System.out.println(this.name + " fired an arrow");
//    }
}
