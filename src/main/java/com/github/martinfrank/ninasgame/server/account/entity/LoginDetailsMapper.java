package com.github.martinfrank.ninasgame.server.account.entity;

public class LoginDetailsMapper {

    public static LoginDetails fromModel(com.github.martinfrank.ninasgame.model.account.LoginDetails from){
        if(from == null){
            return null;
        }
        return new LoginDetails(null, from.getUserName(), from.getUserPass());
    }

    public static com.github.martinfrank.ninasgame.model.account.LoginDetails toModel(LoginDetails from){
        if(from == null){
            return null;
        }
        return new com.github.martinfrank.ninasgame.model.account.LoginDetails( from.getUserName(), from.getUserPass() );
    }

}
