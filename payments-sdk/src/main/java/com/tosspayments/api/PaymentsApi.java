package com.tosspayments.api;

import com.tosspayments.api.model.CardPromotion;
import com.tosspayments.api.model.PaymentDetail;
import com.tosspayments.api.common.RequestMethod;
import com.tosspayments.api.param.CancelParams;
import com.tosspayments.api.param.ConfirmParams;
import com.tosspayments.api.param.GetByOrderIdParams;
import com.tosspayments.api.param.GetParams;
import com.tosspayments.exception.TossPaymentsClientException;
import com.tosspayments.exception.TossPaymentsResponseException;

import java.util.List;

public interface PaymentsApi {
    enum Endpoint {
        Confirm("/v1/payments/{0}", RequestMethod.POST),
        Get("/v1/payments/{0}", RequestMethod.GET),
        GetByOrderId("/v1/payments/orders/{0}", RequestMethod.GET),
        Cancel("/v1/payments/{0}/cancel", RequestMethod.POST),
        GetCardPromotions("/v1/promotions/card", RequestMethod.GET);

        private final String path;
        private final RequestMethod method;

        Endpoint(String path, RequestMethod method) {
            this.path = path;
            this.method = method;
        }

        public String getPath() {
            return path;
        }

        public RequestMethod getMethod() {
            return method;
        }
    }

    PaymentDetail confirm(ConfirmParams params) throws TossPaymentsResponseException, TossPaymentsClientException;

    PaymentDetail get(GetParams params) throws TossPaymentsResponseException, TossPaymentsClientException;

    PaymentDetail getByOrderId(GetByOrderIdParams params) throws TossPaymentsResponseException, TossPaymentsClientException;

    PaymentDetail cancel(CancelParams params) throws TossPaymentsResponseException, TossPaymentsClientException;

    List<CardPromotion> getCardPromotions() throws TossPaymentsResponseException, TossPaymentsClientException;
}
