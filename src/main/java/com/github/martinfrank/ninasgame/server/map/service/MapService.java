package com.github.martinfrank.ninasgame.server.map.service;

import com.github.martinfrank.ninasgame.server.map.entity.Map;

import java.util.List;

public interface MapService {

    Map create(Map person);

    Map update(Map person);

    List<Map> getAll();

    Map getById(long id);

    void delete(long id);

    Map getByName(String name);

}
