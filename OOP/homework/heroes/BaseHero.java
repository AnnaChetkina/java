package OOP.homework.heroes;

import OOP.homework.BaseHeroInterface;

import java.util.List;
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
    protected Point2D point2D;
    protected String side; // todo пропихнуть во все файлы если нужно

    static {
        BaseHero.heroCnt  = 0;
        BaseHero.r = new Random();
    }

    public BaseHero(int attack, int defense, int maxDamage, int minDamage, int hp, int speed, String name, int x, int y) {
        this.attack = attack;
        this.defense = defense;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.hp = hp; // health
        this.speed = speed;
        this.name = name;
        heroCnt ++;
        this.point2D = new Point2D(x, y);
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

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public String getSide() {
        return side;
    }

    public Point2D getPoint2D() {
        return point2D;
    }

//    public abstract int step(List<BaseHero> side1, List<BaseHero> side2, String type);

//    public abstract int step(List<BaseHero> side1, List<BaseHero> side2, String type);
}

