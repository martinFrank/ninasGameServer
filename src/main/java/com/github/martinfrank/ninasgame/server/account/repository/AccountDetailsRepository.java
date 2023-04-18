package com.github.martinfrank.ninasgame.server.account.repository;

import com.github.martinfrank.ninasgame.server.account.entity.AccountDetails;
import com.github.martinfrank.ninasgame.server.account.entity.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {


}
