package com.github.martinfrank.ninasgame.server.map.repository;

import com.github.martinfrank.ninasgame.server.map.model.Map;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<Map, Long> {
}
