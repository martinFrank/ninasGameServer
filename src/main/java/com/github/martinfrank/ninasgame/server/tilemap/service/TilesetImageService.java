package com.github.martinfrank.ninasgame.server.tilemap.service;

import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetDefinition;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetImage;

import java.util.List;

public interface TilesetImageService {

    TilesetImage create(TilesetImage person);

    TilesetImage update(TilesetImage person);

    List<TilesetImage> getAll();

    TilesetImage getById(long id);

    void delete(long id);

    boolean hasFilename(String filename);
}
