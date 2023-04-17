package com.github.martinfrank.ninasgame.server.tilemap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

@Entity
public class TilesetImage {

    @JsonProperty(required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String filename;
    @Lob
    private String imageContentAsBase64String;

    public TilesetImage(Long id, String filename, String imageContentAsBase64String) {
        this.id = id;
        this.filename = filename;
        this.imageContentAsBase64String = imageContentAsBase64String;
    }

    public TilesetImage( String filename, String imageContentAsBase64String) {
        this(-1L, filename, imageContentAsBase64String);
    }


    public TilesetImage() {
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

    public String getImageContentAsBase64String() {
        return imageContentAsBase64String;
    }

    public void setImageContentAsBase64String(String imageContentAsBase64String) {
        this.imageContentAsBase64String = imageContentAsBase64String;
    }

}
