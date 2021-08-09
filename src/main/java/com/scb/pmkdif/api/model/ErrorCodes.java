package com.scb.pmkdif.api.model;

public enum ErrorCodes {
    SE00001("Internal System Error"),

    // BE
    BE00001("Data not found"),

    // AP
    AP00001("xxx");


    private String message;

    ErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
