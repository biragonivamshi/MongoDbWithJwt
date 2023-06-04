package com.virtusa.MongoDBWithJwt.entitity;

public class AuthenticationResponse {

    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    @Override
    public String toString() {
        return "AuthenticationResponse [jwt=" + jwt + "]";
    }
}
