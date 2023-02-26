package OOP.homework.heroes;

public class Sorcerer extends BaseHero{
    public Sorcerer(String name) {
        super(String.format(name + " #%d", ++Sorcerer.number),
                Sorcerer.r.nextInt(100, 200));
    }

    public Sorcerer() {
        super(String.format("Hero_Sorcerer #%d", ++Sorcerer.number),
                Sorcerer.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("%s", super.getInfo());
    }

    public void castSpell(){
        System.out.println(this.name + " cast a spell");
    }
}
