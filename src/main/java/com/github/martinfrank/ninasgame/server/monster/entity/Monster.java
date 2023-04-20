package com.github.martinfrank.ninasgame.server.monster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.martinfrank.ninasgame.model.monster.Statistics;
import com.github.martinfrank.ninasgame.server.account.entity.AccountDetails;
import com.github.martinfrank.ninasgame.server.map.entity.Map;
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
    private String clazz;
    private String race;
    private double maxLife;
    private double currentLife;
    private double speed;
    private double xpos;
    private double ypos;

    @ManyToOne
    @JsonIgnore
    private Map map;


    public Monster() {
    }

    public Monster(Long id, AccountDetails owner, String name, String clazz, String race, double maxLife, double currentLife, double speed, double xpos, double ypos, Map map) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.clazz = clazz;
        this.race = race;
        this.maxLife = maxLife;
        this.currentLife = currentLife;
        this.speed = speed;
        this.xpos = xpos;
        this.ypos = ypos;
        this.map = map;
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

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public double getXpos() {
        return xpos;
    }

    public void setXpos(double xpos) {
        this.xpos = xpos;
    }

    public double getYpos() {
        return ypos;
    }

    public void setYpos(double ypos) {
        this.ypos = ypos;
    }

    public double getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(double maxLife) {
        this.maxLife = maxLife;
    }

    public double getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(double currentLife) {
        this.currentLife = currentLife;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


    public AccountDetails getOwner() {
        return owner;
    }

    public void setOwner(AccountDetails owner) {
        this.owner = owner;
    }
}
