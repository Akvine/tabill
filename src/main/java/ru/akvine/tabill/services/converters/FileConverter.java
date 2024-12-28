package ru.akvine.tabill.services.converters;

import ru.akvine.tabill.enums.Extension;
import ru.akvine.tabill.services.dto.ConvertParams;

import java.io.InputStream;

public interface FileConverter {
    byte[] convert(InputStream inputStream, ConvertParams params);

    Extension getType();
}
