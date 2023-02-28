package OOP.homework.heroes;

import OOP.homework.BaseHeroInterface;

import java.util.Random;

public abstract class BaseHero implements BaseHeroInterface {
    protected static int heroCnt ;
    protected static Random r;

//    атака attack
//    защита defense
//    выстрелы shots
//    урон damage - maxDamage minDamage
//    здоровье health
//    скорость speed
//    доставка delivery
//    магия magic
//    имя



    protected int maxHp;

    protected int attack;
    protected int defense;
    protected int maxDamage;
    protected int minDamage;
    protected int hp;
    protected int speed;
    protected String name;
//    protected int health;

    static {
        BaseHero.heroCnt  = 0;
        BaseHero.r = new Random();
    }

    public BaseHero(int attack, int defense, int maxDamage, int minDamage, int hp, int speed, String name) {
        this.attack = attack;
        this.defense = defense;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.hp = hp; // health
        this.speed = speed;
        this.name = name;
        heroCnt ++;
    }

    public BaseHero(String name) {
        this(0, 0, 0, 0, 0, 0, name);
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

