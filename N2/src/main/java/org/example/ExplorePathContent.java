package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.function.Consumer;

public class ExplorePathContent {
    final private Path PATH;

    public ExplorePathContent(String path) {
        this.PATH = Paths.get(path);
    }

    public Path getPATH() {
        return PATH;
    }

    public static void showEntireTree(Path pathMother, Consumer<String> print) {
        if (Files.isDirectory(pathMother)) {
            print.accept(pathMother.getFileName().toString() + "\\");
            List<Path> paths = getChildren(pathMother);
            if (paths.isEmpty()) {
                print.accept("Empty directory\n");
            } else {
                paths.stream().sorted().forEach(path -> {
                    print.accept(path.getFileName() + markFileOrDirectory(path) + getTimeStampLastModification(path));
                });
                print.accept("");
            }
            for (Path path : paths) {
                showEntireTree(path, print);
            }
        }
    }

    static private List<Path> getChildren(Path path) {
        try {
            return Files.list(path).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static private String getTimeStampLastModification(Path path) {
        try {
            FileTime lastModifiedTime = Files.getLastModifiedTime(path);
            return ", last modified: " + lastModifiedTime.toString().split("T")[0];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static private String markFileOrDirectory(Path path) {
        return (Files.isRegularFile(path) ? "-F" : "-D");
    }
}