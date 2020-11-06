package com.tosspayments.api.model.request;

import com.tosspayments.api.common.TossPaymentsRequestBody;

public class PaymentConfirmBody extends TossPaymentsRequestBody {
    private String orderId;
    private Long amount;

    public PaymentConfirmBody(String orderId, Long amount) {
        this.orderId = orderId;
        this.amount = amount;
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
