package OOP.homework.heroes;

public class Rogue extends Warrior{
    public Rogue(String name, int hp) {
        super(name, hp);
    }

    public Rogue(String name) {
        super(name, Crossbowman.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("I am %s", super.getInfo());
    }

//    public void steal(){
//        System.out.println(this.name + " stole something");
//    }
}
