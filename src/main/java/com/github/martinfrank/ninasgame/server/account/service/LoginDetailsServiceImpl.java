package com.github.martinfrank.ninasgame.server.account.service;

import com.github.martinfrank.ninasgame.server.account.entity.LoginDetails;
import com.github.martinfrank.ninasgame.server.account.repository.LoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LoginDetailsServiceImpl implements LoginDetailsService {


    @Autowired
    private LoginDetailsRepository loginDetailsRepository;


    public LoginDetailsServiceImpl(LoginDetailsRepository loginDetailsRepository){
        this.loginDetailsRepository = loginDetailsRepository;
    }

    @Override
    public LoginDetails create(LoginDetails loginDetails) {
        return loginDetailsRepository.save(loginDetails);
    }

    @Override
    public LoginDetails update(LoginDetails loginDetails) {
        Optional<LoginDetails> loginDetailsCandidate = loginDetailsRepository.findById(loginDetails.getId());
        if (loginDetailsCandidate.isPresent()) {
            LoginDetails loginDetailsToUpdate = loginDetailsCandidate.get();
            loginDetailsToUpdate.setId(loginDetails.getId());
            loginDetailsToUpdate.setUserName(loginDetails.getUserName());
            loginDetailsToUpdate.setUserPass(loginDetails.getUserPass());
            return loginDetailsToUpdate;
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + loginDetails.getId());
        }
    }

    @Override
    public List<LoginDetails> getAll() {
        return loginDetailsRepository.findAll();
    }

    @Override
    public LoginDetails getById(long id) {
        Optional<LoginDetails> candidate = this.loginDetailsRepository.findById(id);
        if (candidate.isPresent()) {
            return candidate.get();
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + id);
        }
    }

    @Override
    public void delete(long id) {
        Optional<LoginDetails> candidate = this.loginDetailsRepository.findById(id);
        if (candidate.isPresent()) {
            this.loginDetailsRepository.delete(candidate.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public LoginDetails getByUserNameAndUserPass(String userName, String userPass) {
        Optional<LoginDetails> candidate = loginDetailsRepository.findByUserNameAndUserPass(userName, userPass);
        return candidate.orElse(null);
    }
}
