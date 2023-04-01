package org.adeda.samgtu_navigation.core.exception;

import org.springframework.http.HttpStatus;

public class InvalidFormatException extends AppException {

    public InvalidFormatException() {
        super("Invalid input format", HttpStatus.BAD_REQUEST);
    }

    public InvalidFormatException(String details) {
        super(details, HttpStatus.BAD_REQUEST);
    }

    public InvalidFormatException(String details, HttpStatus status) {
        super(details, status);
    }
}
