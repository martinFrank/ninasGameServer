package com.github.martinfrank.ninasgame.server.tilemap.entity;

public class TilesetDefinitionMapper {

    public static TilesetDefinition fromModel(com.github.martinfrank.ninasgame.model.tiledmap.TilesetDefinition from){
        return new TilesetDefinition(-1L, from.getName(), from.getFilename(), from.getFileContentAsBase64String(), from.getImageName());
    }

    public static com.github.martinfrank.ninasgame.model.tiledmap.TilesetDefinition toModel(TilesetDefinition from){
        return new com.github.martinfrank.ninasgame.model.tiledmap.TilesetDefinition(from.getName(), from.getFilename(), from.getFileContentAsBase64String(), from.getImageName() );
    }
}
