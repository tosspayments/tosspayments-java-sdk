package com.tosspayments.api.param;

import com.tosspayments.api.common.TossPaymentsRequestBody;

public class PaymentsConfirmParams extends TossPaymentsRequestBody {
    private String orderId;
    private Long amount;

    private PaymentsConfirmParams(String orderId, Long amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public static PaymentsConfirmParams of(String orderId, Long amount) {
        return new PaymentsConfirmParams(
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
