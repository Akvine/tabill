package ru.akvine.tabill.services.converters;

import jakarta.annotation.Nullable;
import ru.akvine.tabill.services.dto.ConvertParams;
import ru.akvine.tabill.utils.Asserts;

import java.io.InputStream;

public abstract class AbstractConverter implements FileConverter {
    protected final String INSERT_INTO_TEMPLATE = "INSERT INTO ";
    protected final String VALUES_TEMPLATE = " VALUES (";
    protected final String CLOSE_TEMPLATE = ");";

    @Override
    @Nullable
    public byte[] convert(InputStream inputStream, ConvertParams params) {
        Asserts.isNotNull(inputStream, "inputStream is null");
        Asserts.isNotNull(params, "params is null");
        return null;
    }
}
