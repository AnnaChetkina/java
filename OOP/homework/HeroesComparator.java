package OOP.homework;

import OOP.homework.heroes.BaseHero;

import java.util.Comparator;

public class HeroesComparator implements Comparator<BaseHero> {
    @Override
    public int compare(BaseHero o1, BaseHero o2) {
        if (o2.getSpeed() == o1.getSpeed()) return o2.getHp() - o1.getHp();
        return o2.getSpeed() - o1.getSpeed();
    }
}

