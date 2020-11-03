package com.tosspayments.api.client;

import com.tosspayments.api.PaymentsApi;
import com.tosspayments.api.common.TossPaymentsRequest;
import com.tosspayments.api.domain.CardPromotion;
import com.tosspayments.api.domain.PaymentDetail;
import com.tosspayments.api.param.PaymentCancelParams;
import com.tosspayments.api.param.PaymentsConfirmParams;
import com.tosspayments.exception.TossPaymentsClientException;
import com.tosspayments.exception.TossPaymentsResponseException;
import com.tosspayments.network.HttpClient;

import java.util.List;

public class PaymentsClient implements PaymentsApi {
    private final HttpClient httpClient;
    private final String host;

    public PaymentsClient(String host, HttpClient httpClient) {
        this.httpClient = httpClient;
        this.host = host;
    }

    @Override
    public PaymentDetail confirm(String paymentKey, PaymentsConfirmParams params) throws TossPaymentsResponseException, TossPaymentsClientException {
        TossPaymentsRequest request = TossPaymentsRequest.ofObject(this.host,
                Endpoint.Confirm, params, PaymentDetail.class, paymentKey);
        return (PaymentDetail) httpClient.request(request).getBody();
    }

    @Override
    public PaymentDetail get(String paymentKey) throws TossPaymentsResponseException, TossPaymentsClientException {
        TossPaymentsRequest request = TossPaymentsRequest.ofObject(this.host,
                Endpoint.Get, null, PaymentDetail.class, paymentKey);
        return (PaymentDetail) httpClient.request(request).getBody();
    }

    @Override
    public PaymentDetail getByOrderId(String orderId) throws TossPaymentsResponseException, TossPaymentsClientException {
        TossPaymentsRequest request = TossPaymentsRequest.ofObject(this.host,
                Endpoint.GetByOrderId, null, PaymentDetail.class, orderId);
        return (PaymentDetail) httpClient.request(request).getBody();
    }

    @Override
    public PaymentDetail cancel(String paymentKey, PaymentCancelParams params) throws TossPaymentsResponseException, TossPaymentsClientException {
        TossPaymentsRequest request = TossPaymentsRequest.ofObject(this.host,
                Endpoint.Cancel, params, PaymentDetail.class, paymentKey);
        return (PaymentDetail) httpClient.request(request).getBody();
    }

    @Override
    public List<CardPromotion> getCardPromotions() throws TossPaymentsResponseException, TossPaymentsClientException {
        TossPaymentsRequest request = TossPaymentsRequest.ofList(this.host,
                Endpoint.GetCardPromotions, null, CardPromotion[].class);
        return (List<CardPromotion>) httpClient.request(request).getList();
    }
}
