package com.tosspayments.api.param;

import com.tosspayments.api.model.request.PaymentConfirmBody;

public class ConfirmParams {
    private final String paymentKey;
    private final PaymentConfirmBody body;

    public ConfirmParams(String paymentKey, PaymentConfirmBody body) {
        this.paymentKey = paymentKey;
        this.body = body;
    }

    public String getPaymentKey() {
        return paymentKey;
    }

    public PaymentConfirmBody getBody() {
        return body;
    }

    public static class Builder {
        private final String paymentKey;
        private final String orderId;
        private final Long amount;

        public Builder(String paymentKey, String orderId, Long amount) {
            this.paymentKey = paymentKey;
            this.orderId = orderId;
            this.amount = amount;
        }

        public ConfirmParams build() {
            return new ConfirmParams(
                    paymentKey,
                    new PaymentConfirmBody(
                            orderId, amount
                    )
            );
        }
    }
}
