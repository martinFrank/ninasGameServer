package com.github.martinfrank.ninasgame.server.tilemap.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.util.List;

@Entity
public class TiledmapDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String filename;
    @Lob
    private String fileContentAsBase64String;
    private List<String> requiredTilesetNames;

    public TiledmapDefinition() {
    }

    public TiledmapDefinition(Long id, String name, String filename, String fileContentAsBase64String, List<String> requiredTilesetNames) {
        this.id = id;
        this.name = name;
        this.filename = filename;
        this.fileContentAsBase64String = fileContentAsBase64String;
        this.requiredTilesetNames = requiredTilesetNames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileContentAsBase64String() {
        return fileContentAsBase64String;
    }

    public void setFileContentAsBase64String(String fileContentAsBase64String) {
        this.fileContentAsBase64String = fileContentAsBase64String;
    }

    public List<String> getRequiredTilesetNames() {
        return requiredTilesetNames;
    }

    public void setRequiredTilesetNames(List<String> requiredTilesetNames) {
        this.requiredTilesetNames = requiredTilesetNames;
    }
}
