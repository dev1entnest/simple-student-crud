package com.example.simple.myspringboot.exceptionns;

import com.example.simple.myspringboot.dtos.ApiResponse;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ApiResponse applicationException(ApplicationException ex){
        String message = ex.getMessage();
        return new ApiResponse().setStatus(404).setMessage(message);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ApiResponse httpMessageNotReadableException(HttpMessageNotReadableException ex){
        String message = ex.getMessage();
        return new ApiResponse(404, message);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse exception(Exception ex){
        String message = ex.getMessage();
        return new ApiResponse(404, message);
    }
}
