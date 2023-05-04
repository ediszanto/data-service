package com.microservices.bootcamp.rds.exception;

public class CsvFileReadException extends Throwable {
    public CsvFileReadException(String message) {
        super(message);
    }

    public CsvFileReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
