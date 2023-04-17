package com.github.martinfrank.ninasgame.server.tilemap.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TilesetDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Long imageId;


    public TilesetDefinition() {
    }

    public TilesetDefinition(String name, Long imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public TilesetDefinition(Long id, String name,Long imageId) {
        this.id = id;
        this.name = name;
        this.imageId = imageId;
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

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }
}
