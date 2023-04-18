package com.github.martinfrank.ninasgame.server.account.service;

import com.github.martinfrank.ninasgame.server.account.entity.LoginDetails;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TiledmapDefinition;

import java.util.List;

public interface LoginDetailsService {

    LoginDetails create(LoginDetails loginDetails);

    LoginDetails update(LoginDetails loginDetails);

    List<LoginDetails> getAll();

    LoginDetails getById(long id);

    void delete(long id);

    LoginDetails getByUserNameAndUserPass(String userName, String userPass);
}
