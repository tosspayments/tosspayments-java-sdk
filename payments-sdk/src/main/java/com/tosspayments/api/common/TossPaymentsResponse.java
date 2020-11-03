package com.tosspayments.api.common;

import java.util.List;

public class TossPaymentsResponse<T extends TossPaymentsResponseBody> {
    private T body;
    private List<? extends TossPaymentsResponseBody> list;

    public TossPaymentsResponse(T body) {
        this.body = body;
    }

    public TossPaymentsResponse(List<? extends TossPaymentsResponseBody> list) {
        this.list = list;
    }

    public T getBody() {
        return body;
    }

    public List<? extends TossPaymentsResponseBody> getList() {
        return list;
    }
}
