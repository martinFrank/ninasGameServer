package com.github.martinfrank.ninasgame.server.item.entity;

import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {

    public static Item fromModel(com.github.martinfrank.ninasgame.model.item.Item from){
        if(from == null){
            return null;
        }
        return new Item(from.getName(), from.getWeight());
    }

    public static List<Item> fromModels(List<com.github.martinfrank.ninasgame.model.item.Item> from){
        if(from == null){
            return null;
        }
        return from.stream().map(ItemMapper::fromModel).collect(Collectors.toList());
    }

    public static com.github.martinfrank.ninasgame.model.item.Item toModel(Item from){
        if(from == null){
            return null;
        }
        return new com.github.martinfrank.ninasgame.model.item.Item(null, from.getName(), from.getWeight() );
    }

    public static List<com.github.martinfrank.ninasgame.model.item.Item> toModels(List<Item> from){
        if(from == null){
            return null;
        }
        return from.stream().map(ItemMapper::toModel).collect(Collectors.toList());
    }
}
