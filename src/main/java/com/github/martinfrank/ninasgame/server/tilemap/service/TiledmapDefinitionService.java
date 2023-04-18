package com.github.martinfrank.ninasgame.server.tilemap.service;

import com.github.martinfrank.ninasgame.server.tilemap.entity.TiledmapDefinition;

import java.util.List;

public interface TiledmapDefinitionService {

    TiledmapDefinition create(TiledmapDefinition map);

    TiledmapDefinition update(TiledmapDefinition map);

    List<TiledmapDefinition> getAll();

    TiledmapDefinition getById(long id);

    void delete(long id);

    TiledmapDefinition getByName(String name);
}
