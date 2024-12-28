package ru.akvine.tabill.exceptions;

public class CellTypeNotSupportedException extends RuntimeException {
    public CellTypeNotSupportedException(String message) {
        super(message);
    }
}
