package com.example.webstore.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApException extends RuntimeException {
    private int code;
    private String message;
}