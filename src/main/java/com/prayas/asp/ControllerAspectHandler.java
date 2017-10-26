package com.kris;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ControllerAspectHandler {

  @ExceptionHandler(NullPointerException.class)
  public ResponseEntity<String> personNotFoundAdvice() {

    return new ResponseEntity<>(
      "Requested book does not exist in the DB"
      , HttpStatus.NOT_FOUND
    );

  }

}
