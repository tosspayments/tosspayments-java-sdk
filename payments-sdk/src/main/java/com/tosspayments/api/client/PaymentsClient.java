package com.tosspayments.api.client;

import com.tosspayments.api.PaymentsApi;
import com.tosspayments.api.common.TossPaymentsRequest;
import com.tosspayments.api.model.CardPromotion;
import com.tosspayments.api.model.PaymentDetail;
import com.tosspayments.api.param.CancelParams;
import com.tosspayments.api.param.ConfirmParams;
import com.tosspayments.api.param.GetByOrderIdParams;
import com.tosspayments.api.param.GetParams;
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
    public PaymentDetail confirm(ConfirmParams params) throws TossPaymentsResponseException, TossPaymentsClientException {
        TossPaymentsRequest request = TossPaymentsRequest.ofObject(this.host,
                Endpoint.Confirm, params.getBody(), PaymentDetail.class, params.getPaymentKey());
        return (PaymentDetail) httpClient.request(request).getBody();
    }

    @Override
    public PaymentDetail get(GetParams params) throws TossPaymentsResponseException, TossPaymentsClientException {
        TossPaymentsRequest request = TossPaymentsRequest.ofObject(this.host,
                Endpoint.Get, null, PaymentDetail.class, params.getPaymentKey());
        return (PaymentDetail) httpClient.request(request).getBody();
    }

    @Override
    public PaymentDetail getByOrderId(GetByOrderIdParams params) throws TossPaymentsResponseException, TossPaymentsClientException {
        TossPaymentsRequest request = TossPaymentsRequest.ofObject(this.host,
                Endpoint.GetByOrderId, null, PaymentDetail.class, params.getOrderId());
        return (PaymentDetail) httpClient.request(request).getBody();
    }

    @Override
    public PaymentDetail cancel(CancelParams params) throws TossPaymentsResponseException, TossPaymentsClientException {
        TossPaymentsRequest request = TossPaymentsRequest.ofObject(this.host,
                Endpoint.Cancel, params.getBody(), PaymentDetail.class, params.getPaymentKey());
        return (PaymentDetail) httpClient.request(request).getBody();
    }

    @Override
    public List<CardPromotion> getCardPromotions() throws TossPaymentsResponseException, TossPaymentsClientException {
        TossPaymentsRequest request = TossPaymentsRequest.ofList(this.host,
                Endpoint.GetCardPromotions, null, CardPromotion[].class);
        return (List<CardPromotion>) httpClient.request(request).getList();
    }
}
