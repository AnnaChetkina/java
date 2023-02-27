package OOP.homework.heroes;

public class Crossbowman extends Shooter{
    public Crossbowman(String name, int hp) {
        super(name, hp);
    }

    public Crossbowman(String name) {
        super(name, Crossbowman.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("I am %s", super.getInfo());
    }

//    public void shootArrow(){
//        System.out.println(this.name + " fired an arrow");
//    }
}
