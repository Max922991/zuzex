package org.city_with_citizens.bank.exception;

import org.city_with_citizens.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class AccountExceptionHandler {

    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ExceptionDto> accountException(AccountException exception) {
        var exceptionDto = ExceptionDto.builder()
                .title(exception.getClass().getName())
                .message(exception.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionDto> noSuchElementException(NoSuchElementException exception) {
        var exceptionDto = ExceptionDto.builder()
                .title(exception.getClass().getName())
                .message(exception.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(
                exceptionDto,
                HttpStatus.NOT_FOUND);
    }

}
