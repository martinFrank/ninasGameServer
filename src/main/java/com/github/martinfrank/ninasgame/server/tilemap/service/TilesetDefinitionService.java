package com.github.martinfrank.ninasgame.server.tilemap.service;

import com.github.martinfrank.ninasgame.server.map.model.Map;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetDefinition;

import java.util.List;

public interface TilesetDefinitionService {

    TilesetDefinition create(TilesetDefinition definition);

    TilesetDefinition update(TilesetDefinition definition);

    List<TilesetDefinition> getAll();

    TilesetDefinition getById(long id);

    void delete(long id);

    TilesetDefinition getByName(String name);
}
