package com.loglens.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LogFileReader {

    public List<String> read(Path path) throws IOException {
        return Files.readAllLines(path);
    }
}