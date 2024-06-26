package com.unpaz.reservas.generic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public interface GenericResponseController {
    Map<String, Object> response = new HashMap<>();
    default void clearResponse() {
        response.clear();
    }
    default ResponseEntity<Map<String, Object>> getResponse(HttpStatus status) {
        return new ResponseEntity<>(response, status);
    }
}
