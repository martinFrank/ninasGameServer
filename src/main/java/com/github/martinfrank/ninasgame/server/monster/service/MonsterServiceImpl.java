package com.github.martinfrank.ninasgame.server.monster.service;

import com.github.martinfrank.ninasgame.server.monster.entity.Monster;
import com.github.martinfrank.ninasgame.server.monster.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MonsterServiceImpl implements MonsterService {


    @Autowired
    private MonsterRepository monsterRepository;


    public MonsterServiceImpl(MonsterRepository monsterRepository){
        this.monsterRepository = monsterRepository;
    }

    @Override
    public Monster create(Monster monster) {
        return monsterRepository.save(monster);
    }

    @Override
    public Monster update(Monster monster) {
        Optional<Monster> loginDetailsCandidate = monsterRepository.findById(monster.getId());
        if (loginDetailsCandidate.isPresent()) {
            Monster monsterToUpdate = loginDetailsCandidate.get();
            monsterToUpdate.setId(monster.getId());
            monsterToUpdate.setName(monster.getName());
            monsterToUpdate.setMap(monster.getMap());
            monsterToUpdate.setXpos(monster.getXpos());
            monsterToUpdate.setYpos(monster.getYpos());
            //FIXME!!!!!
            return monsterToUpdate;
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + monster.getId());
        }
    }

    @Override
    public List<Monster> getAll() {
        return monsterRepository.findAll();
    }

    @Override
    public Monster getById(long id) {
        Optional<Monster> candidate = this.monsterRepository.findById(id);
        if (candidate.isPresent()) {
            return candidate.get();
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + id);
        }
    }

    @Override
    public void delete(long id) {
        Optional<Monster> candidate = this.monsterRepository.findById(id);
        if (candidate.isPresent()) {
            this.monsterRepository.delete(candidate.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

}
