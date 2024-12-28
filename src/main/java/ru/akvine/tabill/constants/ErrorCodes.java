package ru.akvine.tabill.constants;

public final class ErrorCodes {
    private ErrorCodes() throws IllegalAccessException {
        throw new IllegalAccessException("Calling " + ErrorCodes.class.getSimpleName() + " is prohibited!");
    }

    public static final String GENERAL_ERROR = "general.error";

    public interface Validation {
        String FILE_NOT_UPLOADED_ERROR = "file.notUploaded.error";
    }
}
