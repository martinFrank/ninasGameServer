package com.github.martinfrank.ninasgame.server.monster.service;

import com.github.martinfrank.ninasgame.server.monster.entity.Monster;

import java.util.List;

public interface MonsterService {

    Monster create(Monster monster);

    Monster update(Monster monster);

    List<Monster> getAll();

    Monster getById(long id);

    void delete(long id);

}
