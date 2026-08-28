# LogLens

LogLens is a small Java command-line application for analyzing application log files.

It reads a log file, parses each entry and generates a summary to make the logs easier to understand.

## Features

- Read logs from a file
- Parse timestamps, log levels, services and messages
- Count logs by level (INFO, WARN, ERROR)
- Count activity by service
- Find the most frequent error
- Detect and ignore malformed log lines
- Handle missing files
- Accept a log file from the command line
- Unit tests with JUnit

## Log format

LogLens currently expects logs in the following format:

```text
2026-08-28 10:15:32 | ERROR | payment-service | Payment refused
```

Each line contains:

```text
timestamp | level | service | message
```

Example:

```text
2026-08-28 10:15:32 | INFO | auth-service | User logged in
2026-08-28 10:16:04 | ERROR | payment-service | Payment refused
2026-08-28 10:17:21 | WARN | auth-service | Multiple login attempts
2026-08-28 10:18:45 | ERROR | payment-service | Payment refused
```

## Running the project

### Requirements

- Java 25
- Maven

Build the project with:

```bash
mvn clean package
```

Then run LogLens with a log file:

```bash
java -jar target/loglens-1.0-SNAPSHOT.jar sample.log
```

You can replace `sample.log` with another log file that uses the same format.

## Example output

```text
--- LogLens Summary ---

Logs by level:
- INFO: 2
- ERROR: 2
- WARN: 1

Logs by service:
- auth-service: 2
- payment-service: 2

Most frequent error:
- Payment refused

Invalid lines:
- 0
```

## Tests

The project contains unit tests for the parser and the log analyzer.

Run the tests with:

```bash
mvn test
```

The tests cover log parsing, invalid log formats, log level statistics, service statistics and the most frequent error.

## Technologies

- Java
- Maven
- Java Streams
- Java NIO
- JUnit 5

## What I learned

This project helped me practice file handling in Java, parsing structured data and using Streams to analyze collections.

I also practiced command-line arguments, error handling, unit testing with JUnit and building an executable JAR with Maven.
