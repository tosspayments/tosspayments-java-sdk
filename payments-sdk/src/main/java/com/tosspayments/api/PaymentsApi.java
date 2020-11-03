package com.tosspayments.api;

import com.tosspayments.api.common.TossPaymentsRequest;
import com.tosspayments.api.domain.CardPromotion;
import com.tosspayments.api.domain.PaymentDetail;
import com.tosspayments.api.param.PaymentCancelParams;
import com.tosspayments.api.param.PaymentsConfirmParams;
import com.tosspayments.exception.TossPaymentsClientException;
import com.tosspayments.exception.TossPaymentsResponseException;

import java.util.List;

public interface PaymentsApi {
    enum Endpoint {
        Confirm("/v1/payments/{0}", TossPaymentsRequest.Method.POST),
        Get("/v1/payments/{0}", TossPaymentsRequest.Method.GET),
        GetByOrderId("/v1/payments/orders/{0}", TossPaymentsRequest.Method.GET),
        Cancel("/v1/payments/{0}/cancel", TossPaymentsRequest.Method.POST),
        GetCardPromotions("/v1/promotions/card", TossPaymentsRequest.Method.GET);

        private final String path;
        private final TossPaymentsRequest.Method method;

        Endpoint(String path, TossPaymentsRequest.Method method) {
            this.path = path;
            this.method = method;
        }

        public String getPath() {
            return path;
        }

        public TossPaymentsRequest.Method getMethod() {
            return method;
        }
    }

    PaymentDetail confirm(String paymentKey, PaymentsConfirmParams params) throws TossPaymentsResponseException, TossPaymentsClientException;

    PaymentDetail get(String paymentKey) throws TossPaymentsResponseException, TossPaymentsClientException;

    PaymentDetail getByOrderId(String orderId) throws TossPaymentsResponseException, TossPaymentsClientException;

    PaymentDetail cancel(String paymentKey, PaymentCancelParams params) throws TossPaymentsResponseException, TossPaymentsClientException;

    List<CardPromotion> getCardPromotions() throws TossPaymentsResponseException, TossPaymentsClientException;
}
