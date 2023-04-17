package org.adeda.samgtu_navigation.core.exception;

import org.springframework.http.HttpStatus;

public class EntityDependsException extends AppException {
    public EntityDependsException() {
        super("This entity depends on another one", HttpStatus.BAD_REQUEST);
    }

    public EntityDependsException(String details) {
        super(details, HttpStatus.BAD_REQUEST);
    }

    public EntityDependsException(String details, HttpStatus status) {
        super(details, status);
    }
}
