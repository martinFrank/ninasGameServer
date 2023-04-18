package com.github.martinfrank.ninasgame.server.tilemap.repository;

import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetDefinition;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TilesetDefinitionRepository extends JpaRepository<TilesetDefinition, Long> {

    Optional<TilesetDefinition> findByName(String name);

}
