package org.city_with_citizens.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ExceptionDto {

    private String title;
    private String message;
    private HttpStatus httpStatus;

}