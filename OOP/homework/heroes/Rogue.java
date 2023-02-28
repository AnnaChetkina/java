package OOP.homework.heroes;

public class Rogue extends Warrior{
    int id;
    public Rogue(String name, int hp) {
        super(name, hp);
        this.id = super.getheroCnt();
    }

    public Rogue(String name) {
        super(name, Crossbowman.r.nextInt(100, 200));
        this.id = super.getheroCnt();
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

//    public void steal(){
//        System.out.println(this.name + " stole something");
//    }
}
