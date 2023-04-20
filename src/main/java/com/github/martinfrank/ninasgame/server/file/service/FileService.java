package com.github.martinfrank.ninasgame.server.file.service;

import com.github.martinfrank.ninasgame.server.file.entity.File;

import java.util.List;

public interface FileService {

    File create(File file);

    File update(File file);

    List<File> getAll();

    File getById(long id);

    void delete(long id);

    File getByFilename(String filename);
}
