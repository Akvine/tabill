package ru.akvine.tabill.exceptions;

public class FileExtensionNotSupportedException extends RuntimeException {
    public FileExtensionNotSupportedException(String message) {
        super(message);
    }
}
