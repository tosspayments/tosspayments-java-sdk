package com.tosspayments.exception;

public class TossPaymentsClientException extends RuntimeException {
    private final String message;

    public TossPaymentsClientException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
