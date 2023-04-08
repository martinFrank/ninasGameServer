package com.github.martinfrank.ninasgame.server.item.repository;

import com.github.martinfrank.ninasgame.server.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
