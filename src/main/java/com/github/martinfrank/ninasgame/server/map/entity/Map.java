package com.github.martinfrank.ninasgame.server.map.entity;

import com.github.martinfrank.ninasgame.server.item.entity.Item;
import com.github.martinfrank.ninasgame.server.monster.entity.Monster;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String tiledMapDefinition;

    private List<String> requiredFilenames = new ArrayList<>();

    @OneToMany(mappedBy = "map", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Monster> monster = new ArrayList<>();

    @OneToMany(mappedBy = "map", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    public Map() {
    }

    public Map(Long id, String name, String tiledMapDefinition, List<String> requiredFilenames, List<Item> items, List<Monster> monster) {
        this.id = id;
        this.name = name;
        this.tiledMapDefinition = tiledMapDefinition;
        this.requiredFilenames = requiredFilenames;
        this.items = items;
        this.monster = monster;
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

    public String getTiledMapDefinition() {
        return tiledMapDefinition;
    }

    public void setTiledMapDefinition(String tiledMapDefinition) {
        this.tiledMapDefinition = tiledMapDefinition;
    }

    public List<String> getRequiredFilenames() {
        return requiredFilenames;
    }

    public void setRequiredFilenames(List<String> requiredFilenames) {
        this.requiredFilenames = requiredFilenames;
    }

    public List<Monster> getMonster() {
        return monster;
    }

    public void setMonster(List<Monster> monster) {
        this.monster = monster;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}


