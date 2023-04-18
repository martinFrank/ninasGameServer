package com.github.martinfrank.ninasgame.server.tilemap.service;

import com.github.martinfrank.ninasgame.server.tilemap.controller.TilemapController;
import com.github.martinfrank.ninasgame.server.tilemap.entity.TilesetImage;
import com.github.martinfrank.ninasgame.server.tilemap.repository.TilesetImageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TilesetImageServiceImpl implements TilesetImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TilesetImageServiceImpl.class);
    @Autowired
    private final TilesetImageRepository tilesetImageRepository;


    public TilesetImageServiceImpl(TilesetImageRepository tilesetImageRepository){
        this.tilesetImageRepository = tilesetImageRepository;
    }

    @Override
    public TilesetImage create(TilesetImage tilesetDefinition) {
        return tilesetImageRepository.save(tilesetDefinition);
    }

    @Override
    public TilesetImage update(TilesetImage tilesetDefinition) {
        Optional<TilesetImage> mapCandidate = tilesetImageRepository.findById(tilesetDefinition.getId());

        if (mapCandidate.isPresent()) {
            TilesetImage mapToUpdate = mapCandidate.get();
            mapToUpdate.setId(tilesetDefinition.getId());
            mapToUpdate.setFilename(tilesetDefinition.getFilename());
            mapToUpdate.setImageContentAsBase64String(tilesetDefinition.getImageContentAsBase64String());
            return mapToUpdate;
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + tilesetDefinition.getId());
        }
    }

    @Override
    public List<TilesetImage> getAll() {
        return tilesetImageRepository.findAll();
    }

    @Override
    public TilesetImage getById(long id) {
        Optional<TilesetImage> candidate = this.tilesetImageRepository.findById(id);
        if (candidate.isPresent()) {
            return candidate.get();
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + id);
        }
    }

    @Override
    public TilesetImage getByFilename(String filename) {
        Optional<TilesetImage> candidate = this.tilesetImageRepository.findByFilename(filename);
        return candidate.orElse(null);
    }

    @Override
    public TilesetImage getByName(String name) {
        Optional<TilesetImage> candidate = this.tilesetImageRepository.findByName(name);
        return candidate.orElse(null);
    }

    @Override
    public void delete(long id) {
        Optional<TilesetImage> candidate = this.tilesetImageRepository.findById(id);
        if (candidate.isPresent()) {
            this.tilesetImageRepository.delete(candidate.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

}
