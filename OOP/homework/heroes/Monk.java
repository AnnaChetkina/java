package OOP.homework.heroes;

public class Monk extends Healer{
    public Monk(String name, int hp) {
        super(name, hp);
    }

    public Monk(String name) {
        super(name, Crossbowman.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("I am %s", super.getInfo());
    }
//    public void pray(){
//        System.out.println(this.name + " pray to God");
//    }
}
