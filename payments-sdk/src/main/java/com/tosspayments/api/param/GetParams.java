package com.tosspayments.api.param;

public class GetParams {
    private final String paymentKey;

    private GetParams(String paymentKey) {
        this.paymentKey = paymentKey;
    }

    public String getPaymentKey() {
        return paymentKey;
    }

    public static GetParams of(String paymentKey) {
        return new GetParams(paymentKey);
    }
}
