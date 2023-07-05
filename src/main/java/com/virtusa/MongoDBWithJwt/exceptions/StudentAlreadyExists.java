package com.virtusa.MongoDBWithJwt.exceptions;

public class StudentAlreadyExists extends RuntimeException {
    public StudentAlreadyExists(String msg) {
        super(msg);
    }
}
