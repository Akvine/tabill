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
        if (StringUtils.isBlank(value) || symbolsAtEnd > value.length()) {
            return value;
        }

        return value.substring(0, value.length() - symbolsAtEnd);
    }
}
