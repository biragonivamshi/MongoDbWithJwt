package com.virtusa.MongoDBWithJwt.exceptions;

public class ResponseError {
    private String errorMessage;
    private String errorStatus;

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorStatus() {
        return errorStatus;
    }
    public void setErrorStatus(String errorStatus) {
        this.errorStatus = errorStatus;
    }
}
