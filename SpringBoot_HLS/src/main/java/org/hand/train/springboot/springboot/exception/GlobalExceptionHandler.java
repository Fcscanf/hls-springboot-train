package org.hand.train.springboot.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

/**
 * NameException
 * <p>
 * encoding:UTF-8
 *
 * @author Fcant
 * @date 10:02 2019/12/4
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        log.error("method argument not valid: {}", exception.getMessage());
        String errorMessage = "field error";

        BindingResult bindingResult = exception.getBindingResult();
        if (bindingResult.hasErrors()) {
            errorMessage = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.joining(" | "));
        }

        return errorMessage;
    }
}
