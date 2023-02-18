package ru.netology.springboot2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> getInvalidCredentials(InvalidCredentials e){
        return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> getUnauthorizedUser(UnauthorizedUser e){
        System.out.println(e.getMessage());
        return new ResponseEntity(e.getMessage(),HttpStatus.UNAUTHORIZED);
    }
}