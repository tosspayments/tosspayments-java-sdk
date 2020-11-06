package com.tosspayments;

import com.google.gson.Gson;
import com.tosspayments.api.PaymentsApi;
import com.tosspayments.api.client.PaymentsClient;
import com.tosspayments.network.HttpBasicAuthProvider;
import com.tosspayments.network.HttpClient;

public class TossPayments {

    private final PaymentsApi paymentsApi;

    private TossPayments(PaymentsApi paymentsApi) {
        this.paymentsApi = paymentsApi;
    }

    public static class Builder {
        private final String secretKey;
        private Gson gson;
        private String paymentApiHost = "https://api.tosspayments.com";
        private int connectTimeout = 5000;
        private int readTimeout = 10000;

        public Builder(String secretKey) {
            this.secretKey = secretKey;
        }

        public Builder withGson(Gson gson) {
            this.gson = gson;
            return this;
        }

        public Builder withPaymentApiHost(String paymentApiHost) {
            this.paymentApiHost = paymentApiHost;
            return this;
        }

        public Builder withConnectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public Builder withReadTimeout(int readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public TossPayments build() {
            HttpBasicAuthProvider keyProvider = new HttpBasicAuthProvider(this.secretKey);
            if (gson == null) gson = new Gson();
            HttpClient client = new HttpClient(keyProvider, gson);
            client.setConnectTimeout(connectTimeout);
            client.setReadTimeout(readTimeout);

            return new TossPayments(new PaymentsClient(
                    this.paymentApiHost, client
            ));
        }
    }

    public PaymentsApi payments() {
        return paymentsApi;
    }
}
