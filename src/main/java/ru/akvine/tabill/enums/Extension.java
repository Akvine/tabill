package ru.akvine.tabill.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.akvine.tabill.exceptions.FileExtensionNotSupportedException;

@Getter
@AllArgsConstructor
public enum Extension {
    CSV("csv"),
    XSLX("xlsx"),
    XLS("xls");

    private final String value;

    public static Extension from(String extension) {
        for (Extension enumExtension : values()) {
            if (enumExtension.getValue().equals(extension)) {
                return enumExtension;
            }
        }

        String errorMessage = String.format(
                "File with extension = [%s] is not supported by app!",
                extension
        );
        throw new FileExtensionNotSupportedException(errorMessage);
    }
}
