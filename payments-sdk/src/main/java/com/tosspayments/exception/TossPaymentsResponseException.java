package com.tosspayments.exception;

import com.tosspayments.api.common.ErrorBody;

public class TossPaymentsResponseException extends RuntimeException {
    private final ErrorBody error;

    public TossPaymentsResponseException(ErrorBody error) {
        this.error = error;
    }

    public ErrorBody getError() {
        return error;
    }
}
