package com.github.martinfrank.ninasgame.server.tilemap.entity;

public class TiledmapDefinitionMapper {

    public static TiledmapDefinition fromModel(com.github.martinfrank.ninasgame.model.tiledmap.TiledmapDefinition from){
        return new TiledmapDefinition(-1L, from.getName(), from.getFilename(), from.getFileContentAsBase64String(), from.getRequiredTilesetNames() );
    }

    public static com.github.martinfrank.ninasgame.model.tiledmap.TiledmapDefinition toModel(TiledmapDefinition from){
        return new com.github.martinfrank.ninasgame.model.tiledmap.TiledmapDefinition(from.getName(), from.getFilename(), from.getFileContentAsBase64String(), from.getRequiredTilesetNames() );
    }
}
