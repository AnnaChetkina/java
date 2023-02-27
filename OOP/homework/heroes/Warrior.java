package OOP.homework.heroes;

public class Warrior extends BaseHero{
    public Warrior(String name, int hp) {
        super(name, hp);
    }

    public Warrior(String name) {
        super(name);
    }

    public String getInfo() {
        return super.getInfo();
    }
}
