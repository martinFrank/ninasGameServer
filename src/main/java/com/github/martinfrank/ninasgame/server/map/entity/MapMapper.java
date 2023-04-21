package com.github.martinfrank.ninasgame.server.map.entity;

import com.github.martinfrank.ninasgame.server.item.entity.ItemMapper;
import com.github.martinfrank.ninasgame.server.monster.entity.MonsterMapper;

public class MapMapper {

    public static Map fromModel(com.github.martinfrank.ninasgame.model.map.Map from){
        if(from == null){
            return null;
        }
        return new Map(null, from.getName(), from.getMapFilename(), from.getQueueName(), from.getRequiredFilenames(), ItemMapper.fromModels(from.getItems()), MonsterMapper.fromModels(from.getMonsters()));
    }

    public static com.github.martinfrank.ninasgame.model.map.Map toModel(Map from){
        if(from == null){
            return null;
        }
        return new com.github.martinfrank.ninasgame.model.map.Map( from.getName(), from.getTiledMapDefinition(), from.getQueueName(), from.getRequiredFilenames(), ItemMapper.toModels(from.getItems()), MonsterMapper.toModels(from.getMonster()));
    }

}
