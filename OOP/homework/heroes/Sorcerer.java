package OOP.homework.heroes;

public class Sorcerer extends Healer{
    public Sorcerer(String name, int hp) {
        super(name, hp);
    }

    public Sorcerer(String name) {
        super(name, Crossbowman.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("I am %s", super.getInfo());
    }
//    public void castSpell(){
//        System.out.println(this.name + " cast a spell");
//    }
}

