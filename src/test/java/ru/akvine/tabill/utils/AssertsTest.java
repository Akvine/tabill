package ru.akvine.tabill.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("AssertsTest")
public class AssertsTest {
    @Test
    @DisplayName("Throw exception if object is null")
    void throw_exception_if_object_is_null() {
        Object value = null;
        assertThatThrownBy(() -> Asserts.isNotNull(value, "object is null")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Not throw exception if object is not null")
    void not_throw_exception_if_object_is_not_null() {
        Object value = new Object();
        assertDoesNotThrow(() -> Asserts.isNotNull(value, "object is null"));
    }
}
