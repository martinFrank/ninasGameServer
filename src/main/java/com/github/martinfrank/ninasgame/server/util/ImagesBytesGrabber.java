package com.github.martinfrank.ninasgame.server.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class ImagesBytesGrabber {

    public static void main(String[] args) {
        ImagesBytesGrabber br = new ImagesBytesGrabber();
        br.grabBytes("C:\\Users\\m.frank\\IdeaProjects\\privat\\TileMapReader\\src\\main\\resources\\UltimaHackTiled\\tilesets\\u6.png");
    }

    private void grabBytes(String filename) {
        try {
            byte[] bytes = Files.readAllBytes(new File(filename).toPath());
            String base64Representation = new String(Base64.getEncoder().encode(bytes));
            System.out.println(base64Representation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
