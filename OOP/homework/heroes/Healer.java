package OOP.homework.heroes;

public abstract class Healer extends BaseHero {
    public Healer(String name, int hp) {
        super(name, hp);
    }

    public Healer(String name) {
        super(name);
    }

    public String getInfo() {
        return super.getInfo();
    }
}
