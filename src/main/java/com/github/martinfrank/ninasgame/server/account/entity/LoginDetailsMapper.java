package com.github.martinfrank.ninasgame.server.account.entity;

public class LoginDetailsMapper {

    public LoginDetails fromModel(com.github.martinfrank.ninasgame.model.account.LoginDetails from){
        return new LoginDetails(null, from.getUserName(), from.getUserPass());
    }

    public com.github.martinfrank.ninasgame.model.account.LoginDetails toModel(LoginDetails from){
        return new com.github.martinfrank.ninasgame.model.account.LoginDetails( from.getUserName(), from.getUserPass() );
    }

}
