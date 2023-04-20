package com.github.martinfrank.ninasgame.server.account.controller;

import com.github.martinfrank.ninasgame.model.account.AccountDetails;
import com.github.martinfrank.ninasgame.model.account.CreatePlayerDetails;
import com.github.martinfrank.ninasgame.model.account.LoginDetails;
import com.github.martinfrank.ninasgame.model.monster.Monster;
import com.github.martinfrank.ninasgame.server.account.entity.AccountDetailsMapper;
import com.github.martinfrank.ninasgame.server.account.entity.LoginDetailsMapper;
import com.github.martinfrank.ninasgame.server.account.service.AccountDetailsService;
import com.github.martinfrank.ninasgame.server.account.service.LoginDetailsService;
import com.github.martinfrank.ninasgame.server.monster.entity.MonsterMapper;
import com.github.martinfrank.ninasgame.server.monster.service.MonsterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AccountDetailsService accountDetailsService;

    @Autowired
    private LoginDetailsService loginDetailsService;

    @Autowired
    private MonsterService monsterService;



    @PostMapping()
    public ResponseEntity<AccountDetails> postAccount(@RequestBody LoginDetails loginDetails) {
        LOGGER.debug("post /account");

        com.github.martinfrank.ninasgame.server.account.entity.LoginDetails fromDbLoginDetails = loginDetailsService.getByUserNameAndUserPass(loginDetails.getUserName(), loginDetails.getUserPass());
        if(fromDbLoginDetails == null){
            LOGGER.debug("post /account 404 login details not found in db");
            return ResponseEntity.notFound().build();
        }
        com.github.martinfrank.ninasgame.server.account.entity.AccountDetails fromDbAccountDetails = accountDetailsService.getBytLoginDetails(fromDbLoginDetails);
        if(fromDbAccountDetails == null){
            LOGGER.debug("post /account 404 accountDetails for login not found in db");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(AccountDetailsMapper.toModel(fromDbAccountDetails));
//        Monster m1 = new Monster(-1L, "Toshi", "map", 3, 3);
//        Monster m2 = new Monster(-1L, "Algred", "map", 3, 3);
//
//        com.github.martinfrank.ninasgame.server.account.entity.AccountDetails accountDetails = new com.github.martinfrank.ninasgame.server.account.entity.AccountDetails(
//                -1L,
//                "Mario",
//                LoginDetailsMapper.fromModel(loginDetails),
//                new ArrayList<>());
////        accountDetails.getPlayerCharacters().add(m1);
////        accountDetails.getPlayerCharacters().add(m2);
//        return ResponseEntity.ok().body(AccountDetailsMapper.toModel(accountDetails));
    }

    @PostMapping("/create")
    public ResponseEntity<AccountDetails> createAccount(@RequestBody AccountDetails accountDetails) {
        LOGGER.debug("post /account/create");

        com.github.martinfrank.ninasgame.server.account.entity.LoginDetails fromDbLoginDetails = loginDetailsService.getByUserNameAndUserPass(accountDetails.getLoginDetails().getUserName(), accountDetails.getLoginDetails().getUserPass());
        if (fromDbLoginDetails == null){
            fromDbLoginDetails = loginDetailsService.create(LoginDetailsMapper.fromModel(accountDetails.getLoginDetails()));
            com.github.martinfrank.ninasgame.server.account.entity.AccountDetails newDetails = AccountDetailsMapper.fromModel(accountDetails);
            newDetails.setLoginDetails(fromDbLoginDetails);
            com.github.martinfrank.ninasgame.server.account.entity.AccountDetails fromDbAccountDetails = accountDetailsService.create(newDetails);
            return ResponseEntity.ok().body(AccountDetailsMapper.toModel(fromDbAccountDetails));
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    @PostMapping("/createplayer")
    public ResponseEntity<Monster> createPlayer(@RequestBody CreatePlayerDetails createPlayerDetails) {
        LOGGER.debug("get /accounts/createplayer");
        com.github.martinfrank.ninasgame.server.account.entity.LoginDetails fromDbLoginDetails =
                loginDetailsService.getByUserNameAndUserPass(
                        createPlayerDetails.getAccountDetails().getLoginDetails().getUserName(),
                        createPlayerDetails.getAccountDetails().getLoginDetails().getUserPass());
        LOGGER.debug("fromDbLoginDetails: {}", fromDbLoginDetails);
        if (fromDbLoginDetails != null){
            com.github.martinfrank.ninasgame.server.account.entity.AccountDetails fromDbAccountDetails = accountDetailsService.getBytLoginDetails(fromDbLoginDetails);
            LOGGER.debug("fromDbAccountDetails: {}", fromDbLoginDetails);
            com.github.martinfrank.ninasgame.server.monster.entity.Monster player = MonsterMapper.fromModel(createPlayerDetails.getPlayer());
            player.setOwner(fromDbAccountDetails);
            player.setMap(null); //FIXME map!!!!
            player.setXpos(12); //FIXME map!!!!
            player.setYpos(12); //FIXME map!!!!
            com.github.martinfrank.ninasgame.server.monster.entity.Monster playerFromDb = monsterService.create(player);
            LOGGER.debug("playerFromDb: {}", playerFromDb);
            return ResponseEntity.ok().body(MonsterMapper.toModel(playerFromDb));
        }
        return ResponseEntity.notFound().build();
    }

//    @PutMapping("/")
//    public ResponseEntity<AccountDetails> putAccount(@RequestBody AccountDetails accountDetails) {
//        LOGGER.debug("put /account/");
//        return ResponseEntity.ok().body(new AccountDetails());
//    }

}
