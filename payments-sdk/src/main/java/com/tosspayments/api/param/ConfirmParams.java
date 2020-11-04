package com.tosspayments.api.param;

import com.tosspayments.api.model.request.PaymentConfirmBody;

public class ConfirmParams {
    private final String paymentKey;
    private PaymentConfirmBody body;

    private ConfirmParams(String paymentKey) {
        this.paymentKey = paymentKey;
    }

    private void setBody(PaymentConfirmBody body) {
        this.body = body;
    }

    public String getPaymentKey() {
        return paymentKey;
    }

    public PaymentConfirmBody getBody() {
        return body;
    }

    public static ConfirmParams of(String paymentKey, String orderId, Long amount) {
        ConfirmParams params = new ConfirmParams(paymentKey);
        params.setBody(PaymentConfirmBody.of(orderId, amount));
        return params;
    }
}
