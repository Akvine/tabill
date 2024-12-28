package ru.akvine.tabill.exceptions.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.akvine.tabill.exceptions.ValidationException;
import ru.akvine.tabill.rest.dto.ErrorResponse;

import static ru.akvine.tabill.constants.ErrorCodes.GENERAL_ERROR;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        logger.error("Some error was occurred, exception = ", exception);
        ErrorResponse errorResponse = new ErrorResponse(GENERAL_ERROR, exception.getMessage(), exception.getMessage());
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException exception) {
        logger.info("Validation exception, message = {}", exception);
        ErrorResponse errorResponse = new ErrorResponse(exception.getCode(), exception.getMessage(), exception.getMessage());
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
