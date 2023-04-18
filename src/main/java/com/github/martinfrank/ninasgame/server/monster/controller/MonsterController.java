package com.github.martinfrank.ninasgame.server.monster.controller;

import com.github.martinfrank.ninasgame.model.account.AccountDetails;
import com.github.martinfrank.ninasgame.model.account.LoginDetails;
import com.github.martinfrank.ninasgame.server.monster.entity.Monster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monsters") //https://restfulapi.net/resource-naming/ should be PLURAL!
public class MonsterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonsterController.class);


    @GetMapping("/generate")
    public ResponseEntity<Monster> getMonster() {
        LOGGER.debug("get /account/");
        return ResponseEntity.ok().body(new Monster());
    }

}
