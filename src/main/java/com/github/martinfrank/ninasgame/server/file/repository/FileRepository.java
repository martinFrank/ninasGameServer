package com.github.martinfrank.ninasgame.server.file.repository;

import com.github.martinfrank.ninasgame.server.file.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Long> {

    Optional<File> findByFilename(String filename);

}
