package org.city_with_citizens.autoshop.exception;

import org.city_with_citizens.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class AutoshopExceptionHandler {

    @ExceptionHandler(ConfirmException.class)
    public ResponseEntity<?> confirmException(ConfirmException exception) {
        var exceptionDto = ExceptionDto.builder()
                .title(exception.getClass().getName())
                .message(exception.getMessage())
                .httpStatus(HttpStatus.BAD_GATEWAY)
                .build();
        return new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_GATEWAY
        );
    }

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<?> orderException(OrderException exception) {
        var exceptionDto = ExceptionDto.builder()
                .title(exception.getClass().getName())
                .message(exception.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> noSuchElementException(NoSuchElementException exception) {
        var exceptionDto = ExceptionDto.builder()
                .title(exception.getClass().getName())
                .message(exception.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(
                exceptionDto,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeException(RuntimeException exception) {
        var exceptionDto = ExceptionDto.builder()
                .title(exception.getClass().getName())
                .message(exception.getMessage())
                .httpStatus(HttpStatus.BAD_GATEWAY)
                .build();
        return new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_GATEWAY
        );
    }

}
