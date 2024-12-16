package com.example.crud_factory.dto.constants;

public enum ResponseCode {

    RESP_NOT_FOUND("404"),
    RESP_SUCCESS("200");

    private String value;

    private ResponseCode(String value) {
        this.value = value;
    }
}
