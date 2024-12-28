package ru.akvine.tabill.utils;

import io.micrometer.common.util.StringUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StringHelper {
    private static final int COUNT_SYMBOLS_AT_END = 1;

    public String removeLastSymbol(String value) {
        return removeLastSymbol(value, COUNT_SYMBOLS_AT_END);
    }

    public String removeLastSymbol(String value, int symbolsAtEnd) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("Remove last symbol: Value is blank");
        }

        if (symbolsAtEnd > value.length()) {
            String errorMessage = String.format(
                    "Symbols at end count = [%s] to delete can't be more than value length = [%s]",
                    symbolsAtEnd, value.length()
            );
            throw new IllegalArgumentException(errorMessage);
        }

        return value.substring(0, value.length() - symbolsAtEnd);
    }
}
