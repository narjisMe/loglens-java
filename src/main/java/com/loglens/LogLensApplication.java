package com.loglens;

import com.loglens.model.LogEntry;
import com.loglens.service.LogAnalyzer;
import com.loglens.service.LogFileReader;
import com.loglens.service.LogParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class LogLensApplication {

    public static void main(String[] args) throws IOException {

        LogFileReader reader = new LogFileReader();
        LogParser parser = new LogParser();

        List<String> lines = reader.read(Path.of("sample.log"));

        List<LogEntry> entries = lines.stream()
                .map(parser::parse)
                .toList();

        entries.forEach(System.out::println);

        LogAnalyzer analyzer = new LogAnalyzer();

        Map<String, Long> countsByLevel = analyzer.countByLevel(entries);
        System.out.println(countsByLevel);

        Map<String, Long> countsByService = analyzer.countByService(entries);
        System.out.println(countsByService);
    }
}