package com.github.martinfrank.ninasgame.server.account.service;

import com.github.martinfrank.ninasgame.server.account.entity.AccountDetails;
import com.github.martinfrank.ninasgame.server.account.entity.LoginDetails;

import java.util.List;

public interface AccountDetailsService {

    AccountDetails create(AccountDetails accountDetails);

    AccountDetails update(AccountDetails accountDetails);

    List<AccountDetails> getAll();

    AccountDetails getById(long id);

    void delete(long id);

}
