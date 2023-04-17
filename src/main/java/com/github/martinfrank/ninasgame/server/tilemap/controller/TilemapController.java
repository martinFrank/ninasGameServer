package com.github.martinfrank.ninasgame.server.tilemap.controller;

import com.github.martinfrank.ninasgame.model.map.Map;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetDefinition;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetImage;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetImageMapper;
import com.github.martinfrank.ninasgame.server.tilemap.service.TilesetDefinitionService;
import com.github.martinfrank.ninasgame.server.tilemap.service.TilesetImageService;
import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //---------------------------------------------
    //tileset-definitions
    @GetMapping("/tileset-definitions")
    public ResponseEntity<TilesetDefinition> getTilesetDefinition(@RequestParam(name = "id") Long id) {
        LOGGER.debug("get tileset-definition... {}", id);
//        return ResponseEntity.ok().body(new TilesetDefinition(-1L, "test", -1L));
        TilesetDefinition tilesetDefinition = tilesetDefinitionService.getById(id);
        if (tilesetDefinition != null) {
            return ResponseEntity.ok().body(tilesetDefinition);
        }
        LOGGER.debug("tileset-definition with {} not found", id);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/tileset-definitions")
    public ResponseEntity<TilesetDefinition> postTilesetDefinition(@RequestBody TilesetDefinition tilesetDefinition) {
        LOGGER.debug("post tileset-definition... ");
        return ResponseEntity.ok().body(new TilesetDefinition(-1L, "test", -1L));
    }

    //---------------------------------------------
    //tileset-images
    @GetMapping("/tileset-images")
    public ResponseEntity<com.github.martinfrank.ninasgame.model.tiledmap.TilesetImage> getTilesetImage(@RequestParam(name = "id") Long id) {
        LOGGER.debug("get tileset-image... {}", id);
        TilesetImage tilesetImage = tilesetImageService.getById(id);
        if (tilesetImage != null) {
            return ResponseEntity.ok().body(TilesetImageMapper.toModel(tilesetImage));
        }
        LOGGER.debug("tileset-image with {} not found", id);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/tileset-images")
    public ResponseEntity<com.github.martinfrank.ninasgame.model.tiledmap.TilesetImage> postTilesetImage(@RequestBody com.github.martinfrank.ninasgame.model.tiledmap.TilesetImage tilesetImage) {
        LOGGER.debug("post tileset-image... {}", tilesetImage);
        if (!tilesetImageService.hasFilename(tilesetImage.getFilename())) {
            TilesetImage created = tilesetImageService.create(TilesetImageMapper.fromModel(tilesetImage));
            return ResponseEntity.ok().body(TilesetImageMapper.toModel(created));
        }
        return ResponseEntity.ok().body(tilesetImage);
    }

}
