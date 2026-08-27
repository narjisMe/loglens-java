package com.loglens.model;

import java.time.LocalDateTime;

public record LogEntry(
        LocalDateTime timestamp,
        String level,
        String service,
        String message
) {
}