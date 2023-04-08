package com.github.martinfrank.ninasgame.server.item.model;

public class ItemMapper {

    public Item fromModel(com.github.martinfrank.ninasgame.model.item.Item from){
        return new Item(from.getName(), from.getWeight());
    }

    public com.github.martinfrank.ninasgame.model.item.Item toModel(Item from){
        return new com.github.martinfrank.ninasgame.model.item.Item(-1L, from.getName(), from.getWeight() );
    }
}
