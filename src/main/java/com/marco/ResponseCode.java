package com.marco;

public enum ResponseCode {
    INTERNAL_ERROR("500"),
    BAD_REQUEST("400"),
    OK("200");

    private String code;

    ResponseCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
