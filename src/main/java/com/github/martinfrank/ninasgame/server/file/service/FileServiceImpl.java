package com.github.martinfrank.ninasgame.server.file.service;

import com.github.martinfrank.ninasgame.server.file.entity.File;
import com.github.martinfrank.ninasgame.server.file.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FileServiceImpl implements FileService {


    @Autowired
    private FileRepository tiledMapDefinitionRepository;


    public FileServiceImpl(FileRepository tiledMapDefinitionRepository){
        this.tiledMapDefinitionRepository = tiledMapDefinitionRepository;
    }

    @Override
    public File create(File file) {
        return tiledMapDefinitionRepository.save(file);
    }

    @Override
    public File update(File file) {
        Optional<File> mapCandidate = tiledMapDefinitionRepository.findById(file.getId());

        if (mapCandidate.isPresent()) {
            File mapToUpdate = mapCandidate.get();
            mapToUpdate.setId(file.getId());
            mapToUpdate.setFilename(file.getFilename());
            mapToUpdate.setFileContentAsBase64String(file.getFileContentAsBase64String());
            return mapToUpdate;
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + file.getId());
        }
    }

    @Override
    public List<File> getAll() {
        return tiledMapDefinitionRepository.findAll();
    }

    @Override
    public File getById(long id) {
        Optional<File> candidate = this.tiledMapDefinitionRepository.findById(id);
        if (candidate.isPresent()) {
            return candidate.get();
        } else {
            throw new ResourceNotFoundException("Person Record not found with id : " + id);
        }
    }

    @Override
    public void delete(long id) {
        Optional<File> candidate = this.tiledMapDefinitionRepository.findById(id);
        if (candidate.isPresent()) {
            this.tiledMapDefinitionRepository.delete(candidate.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public File getByFilename(String filename) {
        Optional<File> candidate = tiledMapDefinitionRepository.findByFilename(filename);
        return candidate.orElse(null);
    }
}
