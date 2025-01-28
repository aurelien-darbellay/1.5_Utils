package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream("org/example/config.properties")) {
            properties.load(inputStream);
            String directoryToExplore = (String) properties.get("directory");
            Path fileToWriteIn = Paths.get((String) properties.get("targetDir") + (String) properties.get("targetFile"));
            ExplorePathContent explorer = new ExplorePathContent(directoryToExplore);
            ExplorePathContent.showEntireTree(explorer.getPATH(), OutputManager.createTxtFilePrinter(fileToWriteIn));
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
    }
}