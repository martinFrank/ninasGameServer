package com.github.martinfrank.ninasgame.server.map.repository;

import com.github.martinfrank.ninasgame.server.map.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MapRepository extends JpaRepository<Map, Long> {

    Optional<Map> findByName(String name);

}
