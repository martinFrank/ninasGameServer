package com.github.martinfrank.ninasgame.server.file.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.util.List;

@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String filename;
    @Lob
    private String fileContentAsBase64String;
    public File() {
    }

    public File(Long id, String filename, String fileContentAsBase64String) {
        this.id = id;
        this.filename = filename;
        this.fileContentAsBase64String = fileContentAsBase64String;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileContentAsBase64String() {
        return fileContentAsBase64String;
    }

    public void setFileContentAsBase64String(String fileContentAsBase64String) {
        this.fileContentAsBase64String = fileContentAsBase64String;
    }

}
