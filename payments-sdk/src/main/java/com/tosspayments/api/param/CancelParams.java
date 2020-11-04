package com.tosspayments.api.param;

import com.tosspayments.api.model.RefundReceiveAccount;
import com.tosspayments.api.model.request.PaymentCancelBody;
import com.tosspayments.api.model.request.PaymentConfirmBody;

public class CancelParams {
    private final String paymentKey;
    private PaymentCancelBody body;

    private CancelParams(String paymentKey) {
        this.paymentKey = paymentKey;
    }

    private void setBody(PaymentCancelBody body) {
        this.body = body;
    }

    public String getPaymentKey() {
        return paymentKey;
    }

    public PaymentCancelBody getBody() {
        return body;
    }

    public static CancelParams of(String paymentKey, String cancelReason) {
        CancelParams params = new CancelParams(paymentKey);
        params.setBody(PaymentCancelBody.of(cancelReason));
        return params;
    }

    public CancelParams setCancelAmount(Long cancelAmount) {
        this.body.setCancelAmount(cancelAmount);
        return this;
    }

    public CancelParams setRefundableAmount(Long refundableAmount) {
        this.body.setRefundableAmount(refundableAmount);
        return this;
    }

    public CancelParams setTaxAmount(Long taxAmount) {
        this.body.setTaxAmount(taxAmount);
        return this;
    }

    public CancelParams setTaxFreeAmount(Long taxFreeAmount) {
        this.body.setTaxFreeAmount(taxFreeAmount);
        return this;
    }

    public CancelParams setRefundReceiveAccount(RefundReceiveAccount refundReceiveAccount) {
        this.body.setRefundReceiveAccount(refundReceiveAccount);
        return this;
    }
}
