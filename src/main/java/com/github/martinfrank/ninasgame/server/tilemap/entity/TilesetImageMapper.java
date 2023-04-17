package com.github.martinfrank.ninasgame.server.tilemap.entity;

public class TilesetImageMapper {

    public static TilesetImage fromModel(com.github.martinfrank.ninasgame.model.tiledmap.TilesetImage from){
        return new TilesetImage(from.getFilename(), from.getImageContentAsBase64String());
    }

    public static com.github.martinfrank.ninasgame.model.tiledmap.TilesetImage toModel(TilesetImage from){
        return new com.github.martinfrank.ninasgame.model.tiledmap.TilesetImage(from.getFilename(), from.getImageContentAsBase64String() );
    }
}
