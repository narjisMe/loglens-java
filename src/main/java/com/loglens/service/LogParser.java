package com.loglens.service;

import com.loglens.model.LogEntry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogParser {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LogEntry parse(String line) {

        String[] parts = line.split("\\|", 4);

        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid log format");
        }

        LocalDateTime timestamp =
                LocalDateTime.parse(parts[0].trim(), FORMATTER);

        String level = parts[1].trim().toUpperCase();
        String service = parts[2].trim();
        String message = parts[3].trim();

        return new LogEntry(
                timestamp,
                level,
                service,
                message
        );
    }
}