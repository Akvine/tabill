package ru.akvine.tabill.managers;

import lombok.AllArgsConstructor;
import ru.akvine.tabill.enums.Extension;
import ru.akvine.tabill.exceptions.FileExtensionNotSupportedException;
import ru.akvine.tabill.services.converters.FileConverter;

import java.util.Map;

@AllArgsConstructor
public class ConvertersManager {
    private final Map<Extension, FileConverter> converters;

    public FileConverter getByExtension(Extension extension) {
        if (converters.containsKey(extension)) {
            return converters.get(extension);
        } else {
            String errorMessage = String.format(
                    "File with extension = [%s] is not supported by app",
                    extension.getValue()
                    );
            throw new FileExtensionNotSupportedException(errorMessage);
        }
    }
}
