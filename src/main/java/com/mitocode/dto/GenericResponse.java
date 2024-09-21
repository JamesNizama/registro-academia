package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GenericResponse<T>(
        int status,
        String message,
        List<T> data
) {
}
