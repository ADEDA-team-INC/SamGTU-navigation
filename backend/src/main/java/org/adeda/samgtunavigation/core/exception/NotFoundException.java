package org.adeda.samgtunavigation.core.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AppException {

    public NotFoundException() {
        super("Entity was not found", HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String details) {
        super(details, HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String details, HttpStatus status) {
        super(details, status);
    }
}
