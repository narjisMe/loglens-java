package com.loglens.service;

import com.loglens.model.LogEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LogAnalyzerTest {

    private LogAnalyzer analyzer;
    private List<LogEntry> entries;

    @BeforeEach
    void setUp() {
        analyzer = new LogAnalyzer();

        entries = List.of(
                new LogEntry(
                        LocalDateTime.of(2026, 8, 28, 10, 15, 32),
                        "INFO",
                        "auth-service",
                        "User logged in"
                ),
                new LogEntry(
                        LocalDateTime.of(2026, 8, 28, 10, 16, 4),
                        "ERROR",
                        "payment-service",
                        "Payment refused"
                ),
                new LogEntry(
                        LocalDateTime.of(2026, 8, 28, 10, 17, 21),
                        "ERROR",
                        "payment-service",
                        "Payment refused"
                )
        );
    }

    @Test
    void shouldCountLogsByLevel() {
        Map<String, Long> result = analyzer.countByLevel(entries);

        assertEquals(1L, result.get("INFO"));
        assertEquals(2L, result.get("ERROR"));
    }

    @Test
    void shouldCountLogsByService() {
        Map<String, Long> result = analyzer.countByService(entries);

        assertEquals(1L, result.get("auth-service"));
        assertEquals(2L, result.get("payment-service"));
    }

    @Test
    void shouldFindMostFrequentError() {
        String result = analyzer.findMostFrequentError(entries);

        assertEquals("Payment refused", result);
    }
}