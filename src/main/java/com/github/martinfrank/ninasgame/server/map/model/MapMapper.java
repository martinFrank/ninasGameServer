package com.github.martinfrank.ninasgame.server.map.model;

public class MapMapper {

    public Map fromModel(com.github.martinfrank.ninasgame.model.map.Map from){
        return new Map(from.getWidth(), from.getHeight());
    }

    public com.github.martinfrank.ninasgame.model.map.Map toModel(Map from){
        return new com.github.martinfrank.ninasgame.model.map.Map(-1L, from.getWidth(), from.getHeight() );
    }

}
