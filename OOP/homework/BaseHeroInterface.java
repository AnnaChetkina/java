package OOP.homework;

import OOP.homework.heroes.BaseHero;

import java.util.List;

public interface BaseHeroInterface {
    void step(List<BaseHero> team1, List<BaseHero> team2);
    String getInfo();
}
