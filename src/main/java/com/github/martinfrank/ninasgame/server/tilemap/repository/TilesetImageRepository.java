package com.github.martinfrank.ninasgame.server.tilemap.repository;

import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetDefinition;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TilesetImageRepository extends JpaRepository<TilesetImage, Long> {

    Optional<TilesetImage> findByFilename(String filename);

    Optional<TilesetImage> findByName(String name);
}
