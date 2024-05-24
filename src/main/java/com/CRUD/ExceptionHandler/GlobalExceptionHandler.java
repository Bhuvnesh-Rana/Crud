package com.CRUD.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> methodArgumentNotvalidExceptionHandle(MethodArgumentNotValidException ex){
        Map<String,String> errMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(errors ->{
            errMap.put(errors.getField(), errors.getDefaultMessage());
        });
        return errMap;
    }
}
