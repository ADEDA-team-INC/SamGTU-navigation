package org.adeda.samgtunavigation.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AppException extends RuntimeException {
    private final String details;

    private final HttpStatus status;

    public AppException(String details, HttpStatus status) {
        super(details);

        this.details = details;
        this.status = status;
    }
}
