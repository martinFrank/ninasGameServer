package com.github.martinfrank.ninasgame.server.tilemap.service;

import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetDefinition;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetImage;

import java.util.List;

public interface TilesetImageService {

    TilesetImage create(TilesetImage image);

    TilesetImage update(TilesetImage image);

    List<TilesetImage> getAll();

    TilesetImage getById(long id);

    void delete(long id);

    TilesetImage getByFilename(String filename);


    TilesetImage getByName(String name);
}
