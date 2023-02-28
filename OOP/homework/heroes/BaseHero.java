package OOP.homework.heroes;

import OOP.homework.BaseHeroInterface;

import java.util.Random;

public abstract class BaseHero implements BaseHeroInterface {
    protected static int heroCnt ;
    protected static Random r;

    protected String name;
    protected int hp;
    protected int maxHp;

    static {
        BaseHero.heroCnt  = 0;
        BaseHero.r = new Random();
    }

    public BaseHero(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        heroCnt ++;
    }

    public BaseHero(String name) {
        this(name, BaseHero.r.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("%s, my name is %s",
                this.getClass().getSimpleName(), this.name);
    }

    public void GetHealed(int Hp) {
        this.hp = Hp + this.hp > this.maxHp ? this.maxHp : Hp + this.hp;
    }

    public void GetDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
    }

    public int Attack(BaseHero target) {
        int damage = BaseHero.r.nextInt(10, 20);
        target.GetDamage(damage);
        return damage;
    }

    public void step(){

    }

    protected int getheroCnt () {
        return heroCnt ;
    }

    public String getName() {
        return name;
    }
}

