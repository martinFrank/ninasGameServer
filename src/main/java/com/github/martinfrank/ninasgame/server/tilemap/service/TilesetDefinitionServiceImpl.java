package com.github.martinfrank.ninasgame.server.tilemap.service;

import com.github.martinfrank.ninasgame.server.map.model.Map;
import com.github.martinfrank.ninasgame.server.map.repository.MapRepository;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetDefinition;
import com.github.martinfrank.ninasgame.server.tilemap.repository.TilesetDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TilesetDefinitionServiceImpl implements TilesetDefinitionService {


    @Autowired
    private TilesetDefinitionRepository tilesetDefinitionRepository;


    public TilesetDefinitionServiceImpl(TilesetDefinitionRepository tilesetDefinitionRepository){
        this.tilesetDefinitionRepository = tilesetDefinitionRepository;
    }

    @Override
    public TilesetDefinition create(TilesetDefinition tilesetDefinition) {
        return tilesetDefinitionRepository.save(tilesetDefinition);
    }

    @Override
    public TilesetDefinition update(TilesetDefinition tilesetDefinition) {
        Optional<TilesetDefinition> mapCandidate = tilesetDefinitionRepository.findById(tilesetDefinition.getId());

        if (mapCandidate.isPresent()) {
            TilesetDefinition mapToUpdate = mapCandidate.get();
            mapToUpdate.setId(tilesetDefinition.getId());
            mapToUpdate.setName(tilesetDefinition.getName());
            mapToUpdate.setImageId(tilesetDefinition.getImageId());
            return mapToUpdate;
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + tilesetDefinition.getId());
        }
    }

    @Override
    public List<TilesetDefinition> getAll() {
        return tilesetDefinitionRepository.findAll();
    }

    @Override
    public TilesetDefinition getById(long id) {
        Optional<TilesetDefinition> candidate = this.tilesetDefinitionRepository.findById(id);
        if (candidate.isPresent()) {
            return candidate.get();
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + id);
        }
    }

    @Override
    public void delete(long id) {
        Optional<TilesetDefinition> candidate = this.tilesetDefinitionRepository.findById(id);
        if (candidate.isPresent()) {
            this.tilesetDefinitionRepository.delete(candidate.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }
}
