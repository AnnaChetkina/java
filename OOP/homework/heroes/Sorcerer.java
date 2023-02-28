package OOP.homework.heroes;

public class Sorcerer extends Healer{
    int id;
    public Sorcerer(String name, int hp) {
        super(name, hp);
        this.id = super.getheroCnt();
    }

    public Sorcerer(String name) {
        super(name, Crossbowman.r.nextInt(100, 200));
        this.id = super.getheroCnt();
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }
//    public void castSpell(){
//        System.out.println(this.name + " cast a spell");
//    }
}

