package com.github.martinfrank.ninasgame.server.file.controller;

import com.github.martinfrank.ninasgame.server.file.entity.File;
import com.github.martinfrank.ninasgame.server.file.entity.FileMapper;
import com.github.martinfrank.ninasgame.server.file.service.FileService;
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

@RestController
@RequestMapping("/files") //https://restfulapi.net/resource-naming/ should be PLURAL!
public class FileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fileService;

    //---------------------------------------------
    //tileset-map
    @GetMapping("")
    public ResponseEntity<com.github.martinfrank.ninasgame.model.file.File> getFile(@RequestParam(name = "filename") String name) {
        LOGGER.debug("get file: {}", name);
        File file = fileService.getByFilename(name);
        if (file != null) {
            return ResponseEntity.ok().body(FileMapper.toModel(file));
        }
        LOGGER.debug("tiledmap-definitions with name {} not found", name);
        return ResponseEntity.notFound().build();

    }

    @PostMapping("")
    public ResponseEntity<com.github.martinfrank.ninasgame.model.file.File> postTiledmapDefinition(@RequestBody com.github.martinfrank.ninasgame.model.file.File file) {
        LOGGER.debug("post file {}", file.getFilename());
        if (fileService.getByFilename(file.getFilename()) == null) {
            File created = fileService.create(FileMapper.fromModel(file));
            return ResponseEntity.ok().body(FileMapper.toModel(created));
        }
        return ResponseEntity.ok().body(file);
    }
}
