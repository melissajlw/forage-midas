package com.jpmc.midascore;

import org.springframework.stereotype.Component;
import org.testcontainers.shaded.org.apache.commons.io.IOUtils;

import java.io.InputStream;

// Loads a file and returns its contents as an array of strings
@Component
public class FileLoader {
    public String[] loadStrings(String path) {
        try {
            // Returns an InputStream for the file
            InputStream inputStream = this.getClass().getResourceAsStream(path);
            // converts file's contents from the InputStream to a UTF-8-encoded String
            String fileText = IOUtils.toString(inputStream, "UTF-8");
            // splits file content into array of strings by line
            return fileText.split(System.lineSeparator());
        } catch (Exception e) {
            return null;
        }
    }
}
