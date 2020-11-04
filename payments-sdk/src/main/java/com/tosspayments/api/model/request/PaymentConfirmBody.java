package com.tosspayments.api.model.request;

import com.tosspayments.api.common.TossPaymentsRequestBody;

public class PaymentConfirmBody extends TossPaymentsRequestBody {
    private String orderId;
    private Long amount;

    private PaymentConfirmBody(String orderId, Long amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public static PaymentConfirmBody of(String orderId, Long amount) {
        return new PaymentConfirmBody(
                orderId, amount
        );
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
