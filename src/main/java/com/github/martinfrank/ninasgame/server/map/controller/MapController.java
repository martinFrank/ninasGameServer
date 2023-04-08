package com.github.martinfrank.ninasgame.server.map.controller;

import com.github.martinfrank.ninasgame.model.map.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maps") //https://restfulapi.net/resource-naming/ should be PLURAL!
public class MapController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapController.class);


    @GetMapping("/generate")
    public ResponseEntity<Map> getMap() {
        System.out.println("get map...");
        return ResponseEntity.ok().body(new Map(-1L, 64, 64));
    }

}
