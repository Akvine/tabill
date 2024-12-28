package ru.akvine.tabill.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Asserts {
    public void isNotNull(Object value, String errorMessage) {
        if (value == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
