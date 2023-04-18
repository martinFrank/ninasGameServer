package com.github.martinfrank.ninasgame.server.tilemap.controller;

import com.github.martinfrank.ninasgame.server.tilemap.entity.TiledmapDefinitionMapper;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TiledmapDefinition;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetDefinition;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetDefinitionMapper;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetImage;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetImageMapper;
import com.github.martinfrank.ninasgame.server.tilemap.service.TiledmapDefinitionService;
import com.github.martinfrank.ninasgame.server.tilemap.service.TilesetDefinitionService;
import com.github.martinfrank.ninasgame.server.tilemap.service.TilesetImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/tiledmaps") //https://restfulapi.net/resource-naming/ should be PLURAL!
public class TilemapController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TilemapController.class);

    @Autowired
    private TilesetImageService tilesetImageService;

    @Autowired
    private TilesetDefinitionService tilesetDefinitionService;

    @Autowired
    private TiledmapDefinitionService tiledMapDefinitionService;

    //---------------------------------------------
    //tileset-definitions
    @GetMapping("/tileset-definitions")
    public ResponseEntity<com.github.martinfrank.ninasgame.model.tiledmap.TilesetDefinition> getTilesetDefinition(@RequestParam(name = "name") String name) {
        LOGGER.debug("get tileset-definition with name: {}", name);
        TilesetDefinition tilesetDefinition = tilesetDefinitionService.getByName(name);
        if (tilesetDefinition != null) {
            return ResponseEntity.ok().body(TilesetDefinitionMapper.toModel(tilesetDefinition));
        }
        LOGGER.debug("tileset-definition with name {} not found", name);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/tileset-definitions")
    public ResponseEntity<com.github.martinfrank.ninasgame.model.tiledmap.TilesetDefinition> postTilesetDefinition(@RequestBody com.github.martinfrank.ninasgame.model.tiledmap.TilesetDefinition tilesetDefinition) {
        LOGGER.debug("post tileset-definition: {}", tilesetDefinition);
        if (tiledMapDefinitionService.getByName(tilesetDefinition.getName()) == null) {
            TilesetDefinition created = tilesetDefinitionService.create(TilesetDefinitionMapper.fromModel(tilesetDefinition));
            return ResponseEntity.ok().body(TilesetDefinitionMapper.toModel(created));
        }
        return ResponseEntity.ok().body(tilesetDefinition);
    }

    //---------------------------------------------
    //tileset-images
    @GetMapping("/tileset-images")
    public ResponseEntity<com.github.martinfrank.ninasgame.model.tiledmap.TilesetImage> getTilesetImage(@RequestParam(name = "name") String name) {
        LOGGER.debug("get tileset-image with name: {}", name);
        TilesetImage tilesetImage = tilesetImageService.getByName(name);
        if (tilesetImage != null) {
            return ResponseEntity.ok().body(TilesetImageMapper.toModel(tilesetImage));
        }
        LOGGER.debug("tileset-image with filename {} not found", name);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/tileset-images")
    public ResponseEntity<com.github.martinfrank.ninasgame.model.tiledmap.TilesetImage> postTilesetImage(@RequestBody com.github.martinfrank.ninasgame.model.tiledmap.TilesetImage tilesetImage) {
        LOGGER.debug("post tileset-image... {}", tilesetImage);
        if (tilesetImageService.getByName(tilesetImage.getName()) == null) {
            TilesetImage created = tilesetImageService.create(TilesetImageMapper.fromModel(tilesetImage));
            return ResponseEntity.ok().body(TilesetImageMapper.toModel(created));
        }
        return ResponseEntity.ok().body(tilesetImage);
    }

    //---------------------------------------------
    //tileset-map
    @GetMapping("/tiledmap-definitions")
    public ResponseEntity<com.github.martinfrank.ninasgame.model.tiledmap.TiledmapDefinition> getTiledMapDefinition(@RequestParam(name = "name") String name) {
        LOGGER.debug("get tiledmap-definitions name: {}", name);
        TiledmapDefinition tiledmapDefinition = tiledMapDefinitionService.getByName(name);
        if (tiledmapDefinition != null) {
            return ResponseEntity.ok().body(TiledmapDefinitionMapper.toModel(tiledmapDefinition));
        }
        LOGGER.debug("tileset-image with {} not found", name);
//        return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(TiledmapDefinitionMapper.toModel(new TiledmapDefinition(-1L, "cellar", "cellar.tmx", "content", Arrays.asList("u6", "se"))));
    }

    @PostMapping("/tiledmap-definitions")
    public ResponseEntity<com.github.martinfrank.ninasgame.model.tiledmap.TiledmapDefinition> postTilesetImage(@RequestBody com.github.martinfrank.ninasgame.model.tiledmap.TiledmapDefinition tiledmapDefinition) {
        LOGGER.debug("post tiledmap-definitions... {}", tiledmapDefinition.getFileContentAsBase64String());
        if (tiledMapDefinitionService.getByName(tiledmapDefinition.getName()) == null) {
            TiledmapDefinition created = tiledMapDefinitionService.create(TiledmapDefinitionMapper.fromModel(tiledmapDefinition));
            return ResponseEntity.ok().body(TiledmapDefinitionMapper.toModel(created));
        }
        return ResponseEntity.ok().body(tiledmapDefinition);
    }
}
