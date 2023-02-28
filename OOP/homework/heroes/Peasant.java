package OOP.homework.heroes;

public class Peasant extends BaseHero{
    int id;
    int delivery;
//    public Peasant(int attack, int defense, int maxDamage, int minDamage, int hp, int speed, int delivery, String name) {
    public Peasant(int delivery, String name) {
        super(1, 1, 1, 1, 1, 3, name);
        this.delivery = delivery;
        this.id = super.getheroCnt();


//        атака	1
//        защита	1
//        выстрелы	0
//        урон	1
//        здоровье	1
//        скорость	3
//        доставка	1
//        магия	0
//        имя


    }

    public Peasant(String name) {
        this(1, name);
//        this(1, 1, 1, 1, 1, 3, 1, name);
//        this.id = super.getheroCnt();
    }

    public String getInfo() {
        return String.format("I am %s (id: %d)", super.getInfo(), this.id);
    }

//    public void plowField(){
//        System.out.println(this.name + " plowed the field");
//    }
}
