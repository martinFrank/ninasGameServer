package com.github.martinfrank.ninasgame.server.map.controller;

import com.github.martinfrank.ninasgame.model.map.Map;
import com.github.martinfrank.ninasgame.server.map.entity.MapMapper;
import com.github.martinfrank.ninasgame.server.map.service.MapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maps") //https://restfulapi.net/resource-naming/ should be PLURAL!
public class MapController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapController.class);

    @Autowired
    private MapService mapService;

    @GetMapping()
    public ResponseEntity<Map> getMap(@RequestParam(name = "name") String name) {
        LOGGER.debug("get /maps?name={}", name);
        Map map = MapMapper.toModel(mapService.getByName(name));
        if(map != null) {
            return ResponseEntity.ok().body(map);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Map> getMap(@RequestBody Map map) {
        LOGGER.debug("post /maps body:{}", map);
        com.github.martinfrank.ninasgame.server.map.entity.Map mapFromDb = mapService.getByName(map.getName());
        if(mapFromDb == null) {
            mapFromDb = mapService.create(MapMapper.fromModel(map));
            return ResponseEntity.ok().body(MapMapper.toModel(mapFromDb));
        }
        return ResponseEntity.notFound().build();
    }
}
