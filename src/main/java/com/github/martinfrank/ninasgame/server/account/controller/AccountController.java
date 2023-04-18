package com.github.martinfrank.ninasgame.server.account.controller;

import com.github.martinfrank.ninasgame.server.account.entity.AccountDetails;
import com.github.martinfrank.ninasgame.server.account.entity.LoginDetails;
import com.github.martinfrank.ninasgame.server.monster.entity.Monster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/accounts") //https://restfulapi.net/resource-naming/ should be PLURAL!
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);



    @PostMapping("/")
    public ResponseEntity<AccountDetails> postAccount(@RequestBody LoginDetails loginDetails) {
        LOGGER.debug("post /account/");
        Monster m1 = new Monster(-1L, "monster", "map", 3, 3);
        Monster m2 = new Monster(-1L, "monster", "map", 3, 3);

        AccountDetails accountDetails = new AccountDetails(
                -1L,
                "name",
                new LoginDetails(-1L, "userName", "userPass"),
                new ArrayList<>());
        accountDetails.getPlayerCharacters().add(m1);
        accountDetails.getPlayerCharacters().add(m2);
        return ResponseEntity.ok().body(accountDetails);
    }

    @PutMapping("/")
    public ResponseEntity<AccountDetails> putAccount(@RequestBody AccountDetails accountDetails) {
        LOGGER.debug("post /account/");
        return ResponseEntity.ok().body(new AccountDetails());
    }

}
