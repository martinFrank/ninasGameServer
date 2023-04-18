package com.github.martinfrank.ninasgame.server.monster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.martinfrank.ninasgame.server.account.entity.AccountDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private AccountDetails owner;

    private String name;

    private String mapName;

    private int xpos;

    private int ypos;

    public AccountDetails getOwner() {
        return owner;
    }

    public void setOwner(AccountDetails owner) {
        this.owner = owner;
    }

    public Monster() {
    }

    public Monster(Long id, String name, String mapName, int xpos, int ypos) {
        this.id = id;
        this.name = name;
        this.mapName = mapName;
        this.xpos = xpos;
        this.ypos = ypos;
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

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }
}
