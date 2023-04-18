package com.github.martinfrank.ninasgame.server.tilemap.repository;

import com.github.martinfrank.ninasgame.server.tilemap.entity.TiledmapDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TiledmapDefinitionRepository extends JpaRepository<TiledmapDefinition, Long> {

    Optional<TiledmapDefinition> findByName(String name);

}
