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

        LogAnalyzer analyzer = new LogAnalyzer();

        Map<String, Long> countsByLevel = analyzer.countByLevel(entries);

        Map<String, Long> countsByService = analyzer.countByService(entries);

        String mostFrequentError = analyzer.findMostFrequentError(entries);

        System.out.println("--- LogLens Summary ---");

        System.out.println("\nLogs by level:");
        countsByLevel.forEach((level, count) ->
                System.out.println("- " + level + ": " + count)
        );

        System.out.println("\nLogs by service:");
        countsByService.forEach((service, count) ->
                System.out.println("- " + service + ": " + count)
        );

        System.out.println("\nMost frequent error:");
        System.out.println("- " + mostFrequentError);

    }
}