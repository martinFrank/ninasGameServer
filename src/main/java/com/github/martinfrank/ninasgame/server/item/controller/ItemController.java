package com.github.martinfrank.ninasgame.server.item.controller;

import com.github.martinfrank.ninasgame.server.item.entity.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items") //https://restfulapi.net/resource-naming/ should be PLURAL!
public class ItemController {

    @GetMapping("/generate")
    public ResponseEntity<Item> getItem() {
        return ResponseEntity.ok().body(new Item("sword", 12));
    }

}
