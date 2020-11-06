package com.tosspayments.api.param;

import com.tosspayments.api.model.BankCode;
import com.tosspayments.api.model.RefundReceiveAccount;
import com.tosspayments.api.model.request.PaymentCancelBody;

public class CancelParams {
    private final String paymentKey;
    private final PaymentCancelBody body;

    private CancelParams(String paymentKey, PaymentCancelBody body) {
        this.paymentKey = paymentKey;
        this.body = body;
    }

    public String getPaymentKey() {
        return paymentKey;
    }

    public PaymentCancelBody getBody() {
        return body;
    }

    public static class Builder {
        private final String paymentKey;
        private final String cancelReason;

        private Long cancelAmount;
        private Long taxAmount;
        private Long taxFreeAmount;
        private Long refundableAmount;
        private RefundReceiveAccount refundReceiveAccount;

        public Builder(String paymentKey, String cancelReason) {
            this.paymentKey = paymentKey;
            this.cancelReason = cancelReason;
        }

        public Builder cancelAmount(Long cancelAmount) {
            this.cancelAmount = cancelAmount;
            return this;
        }

        public Builder taxAmount(Long taxAmount) {
            this.taxAmount = taxAmount;
            return this;
        }

        public Builder taxFreeAmount(Long taxFreeAmount) {
            this.taxFreeAmount = taxFreeAmount;
            return this;
        }

        public Builder refundableAmount(Long refundableAmount) {
            this.refundableAmount = refundableAmount;
            return this;
        }

        public Builder refundReceiveAccount(BankCode bank, String accountNumber, String holderName) {
            this.refundReceiveAccount = new RefundReceiveAccount(bank, accountNumber, holderName);
            return this;
        }

        public CancelParams build() {
            PaymentCancelBody body = new PaymentCancelBody(
                    cancelReason,
                    cancelAmount,
                    taxAmount,
                    taxFreeAmount,
                    refundableAmount,
                    refundReceiveAccount);

            return new CancelParams(paymentKey, body);
        }
    }
}
