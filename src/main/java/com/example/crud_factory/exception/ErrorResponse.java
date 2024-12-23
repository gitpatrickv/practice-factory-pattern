package com.example.crud_factory.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"errorMessage", "details", "timestamp"})
public class ErrorResponse {

    private String errorMessage;
    @JsonProperty("details")
    private List<ErrorMessage> errors;
    private LocalDateTime timestamp;
}
