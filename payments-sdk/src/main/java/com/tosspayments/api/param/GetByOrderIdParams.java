package com.tosspayments.api.param;

import com.tosspayments.api.model.request.PaymentConfirmBody;

public class GetByOrderIdParams {
    private final String orderId;

    private GetByOrderIdParams(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public static GetByOrderIdParams of(String orderId) {
        return new GetByOrderIdParams(orderId);
    }
}
