package com.github.martinfrank.ninasgame.server.account.entity;

import com.github.martinfrank.ninasgame.server.monster.entity.MonsterMapper;

public class AccountDetailsMapper {

    public static AccountDetails fromModel(com.github.martinfrank.ninasgame.model.account.AccountDetails from){
        if(from == null){
            return null;
        }
        return new AccountDetails(null, from.getName(), LoginDetailsMapper.fromModel(from.getLoginDetails()), MonsterMapper.fromModels(from.getPlayers()));
    }

    public static com.github.martinfrank.ninasgame.model.account.AccountDetails toModel(AccountDetails from){
        if(from == null){
            return null;
        }
        return new com.github.martinfrank.ninasgame.model.account.AccountDetails( from.getName(), LoginDetailsMapper.toModel(from.getLoginDetails()), MonsterMapper.toModels(from.getPlayerCharacters()) );
    }
}
