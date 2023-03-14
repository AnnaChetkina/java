package OOP.homework.heroes;

import OOP.homework.BaseHeroInterface;

import java.util.ArrayList;
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
    protected String state;

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
        this.maxHp = hp; // health
        this.speed = speed;
        this.name = name;
        heroCnt ++;
        this.point2D = new Point2D(x, y);
        this.state = "Stand";
    }

    public String getInfo() {
        return String.format("%s, my name is %s, hp = %d",
                this.getClass().getSimpleName(), this.name, this.hp);
    }

    public void getHealed(int Hp) {
        this.hp = Hp + this.hp > this.maxHp ? this.maxHp : Hp + this.hp;
        if (this.hp > 0) {this.state = "Stand";}
    }

//    public int Attack(BaseHero target) {
//        int damage = BaseHero.r.nextInt(10, 20);
//        target.getDamage(damage);
//        return damage;
//    }

    public void step(List<BaseHero> mySide, List<BaseHero> enemySide){
    }

    protected BaseHero findClosest(List<BaseHero> team){
        double min = 100;
        BaseHero resHero = null;
        for (int i = 0; i < team.size(); i++){
            if (min > this.point2D.getDistance(team.get(i).point2D) && !team.get(i).getState().equals("Die")){
                resHero = team.get(i);
                min = this.point2D.getDistance(team.get(i).point2D);
            }
        }
        return resHero;
    }
    protected void getDamage(float damage){
        this.hp -= damage;
        if (this.hp <= 0) {
            this.hp = 0;
            this.state = "Die";
        }
        if (this.hp > this.maxHp) this.hp = maxHp;
//        System.out.println("* hp = " + this.hp);
//        System.out.println("* maxHp = " + this.maxHp);
//        System.out.println("* state = " + this.state);
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

    public Point2D getPoint2D() {
        return point2D;
    }

    public String getState() {
        return state;
    }

    public int[] getCoords() {return new int[]{this.point2D.x, this.point2D.y};}

    @Override
    public String toString() {
        return name +
                " H:" + Math.round(hp) +
                " D:" + defense +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((minDamage + maxDamage)/2)) +
                " " + state;
    }
}

