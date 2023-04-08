package com.github.martinfrank.ninasgame.server.item.service;

import com.github.martinfrank.ninasgame.server.item.model.Item;

import java.util.List;

public interface ItemService {

    Item create(Item person);

    Item update(Item person);

    List<Item> getAll();

    Item getById(long id);

    void delete(long id);

}
