package com.tosspayments.api.model.request;

import com.tosspayments.api.model.RefundReceiveAccount;
import com.tosspayments.api.common.TossPaymentsRequestBody;

public class PaymentCancelBody extends TossPaymentsRequestBody {
    private final String cancelReason;
    private Long cancelAmount;
    private Long taxAmount;
    private Long taxFreeAmount;
    private RefundReceiveAccount refundReceiveAccount;

    private Long refundableAmount;

    private PaymentCancelBody(String cancelReason, Long cancelAmount, Long taxAmount, Long taxFreeAmount, Long refundableAmount, RefundReceiveAccount refundReceiveAccount) {
        this.cancelReason = cancelReason;
        this.cancelAmount = cancelAmount;
        this.taxAmount = taxAmount;
        this.taxFreeAmount = taxFreeAmount;
        this.refundableAmount = refundableAmount;
        this.refundReceiveAccount = refundReceiveAccount;
    }

    public static PaymentCancelBody of(String cancelReason) {
        return new PaymentCancelBody(cancelReason, null, null, 0L, null, null);
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public Long getCancelAmount() {
        return cancelAmount;
    }

    public Long getTaxAmount() {
        return taxAmount;
    }

    public Long getTaxFreeAmount() {
        return taxFreeAmount;
    }

    public Long getRefundableAmount() {
        return refundableAmount;
    }

    public RefundReceiveAccount getRefundReceiveAccount() {
        return refundReceiveAccount;
    }

    public PaymentCancelBody setCancelAmount(Long cancelAmount) {
        this.cancelAmount = cancelAmount;
        return this;
    }

    public PaymentCancelBody setTaxAmount(Long taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    public PaymentCancelBody setTaxFreeAmount(Long taxFreeAmount) {
        this.taxFreeAmount = taxFreeAmount;
        return this;
    }

    public PaymentCancelBody setRefundReceiveAccount(RefundReceiveAccount refundReceiveAccount) {
        this.refundReceiveAccount = refundReceiveAccount;
        return this;
    }

    public PaymentCancelBody setRefundableAmount(Long refundableAmount) {
        this.refundableAmount = refundableAmount;
        return this;
    }
}
