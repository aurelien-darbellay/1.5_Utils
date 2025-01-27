package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ExplorePathContent {
    final private Path PATH;

    public ExplorePathContent(String path) {
        this.PATH = Paths.get(path);
    }

    static private List<Path> mapPathsToFileNames(List<Path> paths) {
        return paths.stream().map(Path::getFileName).collect(Collectors.toList());
    }


    static private String markFileOrDirectory(Path path) {
        return path.toString() + (Files.isRegularFile(path) ? "-F" : "-D");
    }

    static private List<Path> getListedFolderContent(Path path) throws IOException {
        return Files.list(path).collect(Collectors.toList());
    }

    public Path getPATH() {
        return PATH;
    }


    public void showOrderedContent() {
        try {
            List<Path> paths = mapPathsToFileNames(getListedFolderContent(this.PATH));
            paths.sort(null);
            paths.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void showEntireTree(Path pathMother) {
        if (Files.isDirectory(pathMother)) {
            try {
                List<Path> paths = getListedFolderContent(pathMother);
                System.out.format("%s\\%n", pathMother.getFileName());
                if (paths.isEmpty()) {
                    System.out.println("Empty directory\n");

                } else {
                    mapPathsToFileNames(paths).forEach(System.out::println);
                    System.out.println("\n");
                }
                for (Path path : paths) {
                    showEntireTree(path);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}