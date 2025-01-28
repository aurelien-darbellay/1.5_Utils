package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;

public class OutputManager {
    
    static public Consumer<String> createConsolePrinter() {
        return new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
    }

    static private void checkFileExistence(Path path) {
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException("No file at specified path; impossible to create", e);
            }
        }
    }

    static public Consumer<String> createTxtFilePrinter(Path path) {
        return new Consumer<String>() {
            private FileWriter writer;

            {
                checkFileExistence(path);
                try {
                    writer = new FileWriter(path.toString());
                } catch (IOException e) {
                    throw new RuntimeException("Failed to create Filewriter", e);
                }
            }

            @Override
            public void accept(String s) {
                try {
                    writer.write(s + System.lineSeparator());
                    writer.flush();
                } catch (IOException e) {
                    throw new RuntimeException("Failed to write a new line", e);
                }
            }

        };

    }
}
