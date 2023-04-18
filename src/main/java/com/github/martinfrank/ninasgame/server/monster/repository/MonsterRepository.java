package com.github.martinfrank.ninasgame.server.monster.repository;

import com.github.martinfrank.ninasgame.server.monster.entity.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonsterRepository extends JpaRepository<Monster, Long> {

}
