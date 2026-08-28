package com.loglens.service;

import com.loglens.model.LogEntry;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogAnalyzer {

    public Map<String, Long> countByLevel(List<LogEntry> entries) {
        return entries.stream()
                .collect(Collectors.groupingBy(
                        LogEntry::level,
                        Collectors.counting()
                ));
    }

    public Map<String, Long> countByService(List<LogEntry> entries) {
        return entries.stream()
                .collect(Collectors.groupingBy(
                        LogEntry::service,
                        Collectors.counting()
                ));
    }
}