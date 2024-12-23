package com.example.crud_factory.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonPropertyOrder({"field", "value", "message"})
public class ErrorMessage {
    private final String field;
    @JsonProperty("value")
    private final Object rejectedValue;
    private final String message;
}
