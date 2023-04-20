package com.github.martinfrank.ninasgame.server.file.entity;

public class FileMapper {

    public static File fromModel(com.github.martinfrank.ninasgame.model.file.File from){
        if(from == null){
            return null;
        }
        return new File(null, from.getFilename(), from.getFileContentAsBase64String());
    }

    public static com.github.martinfrank.ninasgame.model.file.File toModel(File from){
        if(from == null){
            return null;
        }
        return new com.github.martinfrank.ninasgame.model.file.File(from.getFilename(), from.getFileContentAsBase64String());
    }
}
