package com.tosspayments.api.param;

public class GetParams {
    private final String paymentKey;

    public GetParams(String paymentKey) {
        this.paymentKey = paymentKey;
    }

    public String getPaymentKey() {
        return paymentKey;
    }
}
