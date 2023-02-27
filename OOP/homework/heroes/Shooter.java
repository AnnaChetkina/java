package OOP.homework.heroes;
//

public abstract class Shooter extends BaseHero{
    public Shooter(String name, int hp) {
        super(name, hp);
    }

    public Shooter(String name) {
        super(name);
    }

    public String getInfo() {
       return super.getInfo();
    }

}
