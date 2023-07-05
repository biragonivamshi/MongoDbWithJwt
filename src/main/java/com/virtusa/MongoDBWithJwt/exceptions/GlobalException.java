package com.virtusa.MongoDBWithJwt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler({ InvalidStudentId.class,
            StudentAlreadyExists.class,
            StudentIdDoesntExists.class
    })
    public ResponseEntity ResourseNotFound (Exception Exe)
    {
        ResponseError errObj = new ResponseError();
        errObj.setErrorMessage(Exe.getMessage());
        errObj.setErrorStatus(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<> (Exe.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
