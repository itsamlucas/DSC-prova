package com.example.demo.service;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}