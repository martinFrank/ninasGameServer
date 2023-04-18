package com.github.martinfrank.ninasgame.server.tilemap.service;

import com.github.martinfrank.ninasgame.server.tilemap.entity.TiledmapDefinition;
import com.github.martinfrank.ninasgame.server.tilemap.repository.TiledmapDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TiledmapDefinitionServiceImpl implements TiledmapDefinitionService {


    @Autowired
    private TiledmapDefinitionRepository tiledMapDefinitionRepository;


    public TiledmapDefinitionServiceImpl(TiledmapDefinitionRepository tiledMapDefinitionRepository){
        this.tiledMapDefinitionRepository = tiledMapDefinitionRepository;
    }

    @Override
    public TiledmapDefinition create(TiledmapDefinition tiledmapDefinition) {
        return tiledMapDefinitionRepository.save(tiledmapDefinition);
    }

    @Override
    public TiledmapDefinition update(TiledmapDefinition tiledmapDefinition) {
        Optional<TiledmapDefinition> mapCandidate = tiledMapDefinitionRepository.findById(tiledmapDefinition.getId());

        if (mapCandidate.isPresent()) {
            TiledmapDefinition mapToUpdate = mapCandidate.get();
            mapToUpdate.setId(tiledmapDefinition.getId());
            mapToUpdate.setName(tiledmapDefinition.getName());
            mapToUpdate.setFilename(tiledmapDefinition.getFilename());
            mapToUpdate.setFileContentAsBase64String(tiledmapDefinition.getFileContentAsBase64String());
            mapToUpdate.setRequiredTilesetNames(tiledmapDefinition.getRequiredTilesetNames());
            return mapToUpdate;
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + tiledmapDefinition.getId());
        }
    }

    @Override
    public List<TiledmapDefinition> getAll() {
        return tiledMapDefinitionRepository.findAll();
    }

    @Override
    public TiledmapDefinition getById(long id) {
        Optional<TiledmapDefinition> candidate = this.tiledMapDefinitionRepository.findById(id);
        if (candidate.isPresent()) {
            return candidate.get();
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + id);
        }
    }

    @Override
    public void delete(long id) {
        Optional<TiledmapDefinition> candidate = this.tiledMapDefinitionRepository.findById(id);
        if (candidate.isPresent()) {
            this.tiledMapDefinitionRepository.delete(candidate.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public TiledmapDefinition getByName(String name) {
        Optional<TiledmapDefinition> candidate = tiledMapDefinitionRepository.findByName(name);
        return candidate.orElse(null);
    }
}
