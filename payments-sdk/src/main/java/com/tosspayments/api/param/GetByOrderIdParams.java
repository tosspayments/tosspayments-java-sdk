package com.tosspayments.api.param;

import com.tosspayments.api.model.request.PaymentConfirmBody;

public class GetByOrderIdParams {
    private final String orderId;

    public GetByOrderIdParams(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
