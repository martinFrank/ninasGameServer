package com.github.martinfrank.ninasgame.server.tilemap.repository;

import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TilesetDefinitionRepository extends JpaRepository<TilesetDefinition, Long> {
}
