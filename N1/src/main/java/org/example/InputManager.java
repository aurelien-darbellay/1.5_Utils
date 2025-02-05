package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputManager {
    static public BufferedReader createBufferedReader(Path path) {
        Charset charset = StandardCharsets.UTF_8;
        try {
            return Files.newBufferedReader(path, charset);
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
    }
}
