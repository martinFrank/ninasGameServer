package com.github.martinfrank.ninasgame.server.monster.controller;

import com.github.martinfrank.ninasgame.model.account.AccountDetails;
import com.github.martinfrank.ninasgame.model.account.CreatePlayerDetails;
import com.github.martinfrank.ninasgame.model.account.LoginDetails;
import com.github.martinfrank.ninasgame.model.monster.Monster;
import com.github.martinfrank.ninasgame.server.account.service.AccountDetailsService;
import com.github.martinfrank.ninasgame.server.account.service.LoginDetailsService;
import com.github.martinfrank.ninasgame.server.monster.entity.MonsterMapper;
import com.github.martinfrank.ninasgame.server.monster.service.MonsterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MonsterService monsterService;

    @GetMapping("/generate")
    public ResponseEntity<Monster> getMonster() {
        LOGGER.debug("get /account/");
        return ResponseEntity.ok().body(new Monster());
    }


    @PostMapping("/create")
    public ResponseEntity<Monster> createMonster(@RequestBody Monster monster) {
        LOGGER.debug("get /monsters/create");
        com.github.martinfrank.ninasgame.server.monster.entity.Monster candidate = MonsterMapper.fromModel(monster);
        com.github.martinfrank.ninasgame.server.monster.entity.Monster fromDb = monsterService.create(candidate);
        return ResponseEntity.ok().body(MonsterMapper.toModel(fromDb));
    }



}
