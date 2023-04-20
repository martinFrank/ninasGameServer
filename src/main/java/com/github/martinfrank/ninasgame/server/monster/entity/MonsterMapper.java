package com.github.martinfrank.ninasgame.server.monster.entity;

import com.github.martinfrank.ninasgame.model.monster.Archetype;
import com.github.martinfrank.ninasgame.model.monster.Statistics;

import java.util.List;
import java.util.stream.Collectors;

public class MonsterMapper {
    public static Monster fromModel(com.github.martinfrank.ninasgame.model.monster.Monster from) {
        if(from == null){
            return null;
        }
        return new Monster(
                null,
                null,
                from.getName(),
                from.getArchetype().getClazz(),
                from.getArchetype().getRace(),
                from.getStatistics().getMaxLife(),
                from.getStatistics().getCurrentLife(),
                from.getStatistics().getSpeed(),
                from.getXpos(),
                from.getYpos(),
                null);
    }


    public static List<Monster> fromModels(List<com.github.martinfrank.ninasgame.model.monster.Monster> from) {
        if(from == null){
            return null;
        }
        return from.stream().map(MonsterMapper::fromModel).collect(Collectors.toList());
    }


    public static com.github.martinfrank.ninasgame.model.monster.Monster toModel(Monster from) {
        if(from == null){
            return null;
        }
        return new com.github.martinfrank.ninasgame.model.monster.Monster(
                from.getName(),
                new Archetype(from.getClazz(), from.getRace()),
                new Statistics(from.getMaxLife(), from.getCurrentLife(), from.getSpeed()),
                from.getXpos(),
                from.getYpos(),
                from.getMap() == null ? null: from.getMap().getName());
    }

    public static List<com.github.martinfrank.ninasgame.model.monster.Monster> toModels(List<Monster> from) {
        if(from == null){
            return null;
        }
        return from.stream().map(MonsterMapper::toModel).collect(Collectors.toList());
    }

}
