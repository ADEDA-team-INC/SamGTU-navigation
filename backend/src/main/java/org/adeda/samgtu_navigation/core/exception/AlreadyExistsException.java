package org.adeda.samgtu_navigation.core.exception;

import org.springframework.http.HttpStatus;

public class AlreadyExistsException extends AppException {
    public AlreadyExistsException() {
        super("Given entity already exists", HttpStatus.BAD_REQUEST);
    }

    public AlreadyExistsException(String details) {
        super(details, HttpStatus.BAD_REQUEST);
    }

    public AlreadyExistsException(String details, HttpStatus status) {
        super(details, status);
    }
}
