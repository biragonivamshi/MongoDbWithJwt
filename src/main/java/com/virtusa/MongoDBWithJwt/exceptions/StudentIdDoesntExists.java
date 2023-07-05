package com.virtusa.MongoDBWithJwt.exceptions;

public class StudentIdDoesntExists extends RuntimeException{
    public StudentIdDoesntExists(String msg){
        super(msg);
    }
}
