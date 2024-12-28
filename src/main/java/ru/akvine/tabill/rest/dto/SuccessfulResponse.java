package ru.akvine.tabill.rest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Successful response status
 */
@Data
@Accessors(chain = true)
public class SuccessfulResponse implements Response {

    /**
     * Result response status
     */
    @NotNull
    private final ResponseStatus status = ResponseStatus.SUCCESS;
}