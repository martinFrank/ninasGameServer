package com.github.martinfrank.ninasgame.server.account.service;

import com.github.martinfrank.ninasgame.server.account.entity.AccountDetails;
import com.github.martinfrank.ninasgame.server.account.entity.LoginDetails;
import com.github.martinfrank.ninasgame.server.account.repository.AccountDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountDetailsServiceImpl implements  AccountDetailsService {


    @Autowired
    private AccountDetailsRepository accountDetailsRepository;


    public AccountDetailsServiceImpl(AccountDetailsRepository accountDetailsRepository){
        this.accountDetailsRepository = accountDetailsRepository;
    }

    @Override
    public AccountDetails create(AccountDetails accountDetails) {
        return accountDetailsRepository.save(accountDetails);
    }

    @Override
    public AccountDetails update(AccountDetails accountDetails) {
        Optional<AccountDetails> accountDetailsCandidate = accountDetailsRepository.findById(accountDetails.getId());
        if (accountDetailsCandidate.isPresent()) {
            AccountDetails accountDetailsToUpdate = accountDetailsCandidate.get();
            accountDetailsToUpdate.setId(accountDetails.getId());
            accountDetailsToUpdate.setName(accountDetails.getName());
            accountDetailsToUpdate.setLoginDetails(accountDetails.getLoginDetails());
            accountDetailsToUpdate.setPlayerCharacters(accountDetails.getPlayerCharacters());
            return accountDetailsToUpdate;
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + accountDetails.getId());
        }
    }

    @Override
    public List<AccountDetails> getAll() {
        return accountDetailsRepository.findAll();
    }

    @Override
    public AccountDetails getById(long id) {
        Optional<AccountDetails> candidate = this.accountDetailsRepository.findById(id);
        if (candidate.isPresent()) {
            return candidate.get();
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + id);
        }
    }

    @Override
    public void delete(long id) {
        Optional<AccountDetails> candidate = this.accountDetailsRepository.findById(id);
        if (candidate.isPresent()) {
            this.accountDetailsRepository.delete(candidate.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public AccountDetails getBytLoginDetails(LoginDetails loginDetails) {
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setLoginDetails(loginDetails);
        Example<AccountDetails> example = Example.of(accountDetails);
        Optional<AccountDetails> candidate = accountDetailsRepository.findOne(example);
        return candidate.orElse(null);
    }
}
