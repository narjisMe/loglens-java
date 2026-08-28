package com.loglens.service;

import com.loglens.model.LogEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogParserTest {

    private LogParser parser;

    @BeforeEach
    void setUp() {
        parser = new LogParser();
    }

    @Test
    void parse() {
        String line =
                "2026-08-28 10:15:32 | ERROR | payment-service | Payment refused";

        LogEntry entry = parser.parse(line);

        assertEquals("ERROR", entry.level());
        assertEquals("payment-service", entry.service());
        assertEquals("Payment refused", entry.message());
    }

    @Test
    void shouldRejectInvalidLogLine() {
        String line = "invalid log";

        assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse(line)
        );
    }
}