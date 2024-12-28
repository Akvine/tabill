package ru.akvine.tabill.exceptions;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    private final String code;

    public ValidationException(String code, String message) {
        super(message);
        this.code = code;
    }
}
