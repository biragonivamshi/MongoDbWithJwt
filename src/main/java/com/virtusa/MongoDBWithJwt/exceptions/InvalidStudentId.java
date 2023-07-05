package com.virtusa.MongoDBWithJwt.exceptions;

public class InvalidStudentId extends RuntimeException{
    public InvalidStudentId(String msg){
        super(msg);

    }
}
