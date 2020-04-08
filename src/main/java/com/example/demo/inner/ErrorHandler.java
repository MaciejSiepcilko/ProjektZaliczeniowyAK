package com.example.demo.inner;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class ErrorHandler {

//    @ExceptionHandler(Exception.class)
//    ResponseEntity<ErrorDto> handleUnknownError() {
//        ErrorDto dto = new ErrorDto("UNKNOWN_ERROR");
//        return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(InvalidCountryCodeException.class)
    ResponseEntity<ErrorDto> handleInvalidCountryCode() {
        ErrorDto dto = new ErrorDto("INVALID_COUNTRY_CODE");
        return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataAccessResourceFailureException.class)
    ResponseEntity<ErrorDto> handleDatabaseDown() {
        ErrorDto dto = new ErrorDto("INTERNAL_ERROR");
        return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
