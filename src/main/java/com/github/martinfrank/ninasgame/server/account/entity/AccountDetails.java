package com.github.martinfrank.ninasgame.server.account.entity;

import com.github.martinfrank.ninasgame.server.monster.entity.Monster;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne
    private LoginDetails loginDetails;

    @OneToMany(mappedBy = "owner")
    private List<Monster> playerCharacters = new ArrayList<>();

    public AccountDetails() {
    }

    public AccountDetails(Long id, String name, LoginDetails loginDetails, List<Monster> playerCharacters) {
        this.id = id;
        this.name = name;
        this.loginDetails = loginDetails;
        this.playerCharacters = playerCharacters;
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

    public LoginDetails getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(LoginDetails loginDetails) {
        this.loginDetails = loginDetails;
    }

    public List<Monster> getPlayerCharacters() {
        return playerCharacters;
    }

    public void setPlayerCharacters(List<Monster> playerCharacters) {
        this.playerCharacters = playerCharacters;
    }
}
