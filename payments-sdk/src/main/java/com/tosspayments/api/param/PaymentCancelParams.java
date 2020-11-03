package com.tosspayments.api.param;

import com.tosspayments.api.common.TossPaymentsRequestBody;

public class PaymentCancelParams extends TossPaymentsRequestBody {
    private final String cancelReason;
    private final Long cancelAmount;
    private final Long taxAmount;
    private final Long taxFreeAmount;
    private final RefundReceiveAccount refundReceiveAccount;

    private Long refundableAmount;

    private PaymentCancelParams(String cancelReason, Long cancelAmount, Long taxAmount, Long taxFreeAmount, Long refundableAmount, RefundReceiveAccount refundReceiveAccount) {
        this.cancelReason = cancelReason;
        this.cancelAmount = cancelAmount;
        this.taxAmount = taxAmount;
        this.taxFreeAmount = taxFreeAmount;
        this.refundableAmount = refundableAmount;
        this.refundReceiveAccount = refundReceiveAccount;
    }

    public static PaymentCancelParams of(String cancelReason) {
        return new PaymentCancelParams(cancelReason, null, null, 0L, null, null);
    }

    public static PaymentCancelParams of(String cancelReason, Long cancelAmount) {
        return new PaymentCancelParams(cancelReason, cancelAmount, null, 0L, null, null);
    }

    public static PaymentCancelParams of(String cancelReason, Long cancelAmount, Long taxAmount, Long taxFreeAmount) {
        return new PaymentCancelParams(cancelReason, cancelAmount, taxAmount, taxFreeAmount, null, null);
    }

    public static PaymentCancelParams of(String cancelReason, RefundReceiveAccount refundReceiveAccount) {
        return new PaymentCancelParams(cancelReason, null, null, 0L, null, refundReceiveAccount);
    }

    public static PaymentCancelParams of(String cancelReason, Long cancelAmount, RefundReceiveAccount refundReceiveAccount) {
        return new PaymentCancelParams(cancelReason, cancelAmount, null, 0L, null, refundReceiveAccount);
    }

    public static PaymentCancelParams of(String cancelReason, Long cancelAmount, Long taxAmount, Long taxFreeAmount, RefundReceiveAccount refundReceiveAccount) {
        return new PaymentCancelParams(cancelReason, cancelAmount, taxAmount, taxFreeAmount, null, refundReceiveAccount);
    }

    public PaymentCancelParams setRefundableAmount(Long refundableAmount) {
        this.refundableAmount = refundableAmount;
        return this;
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
}
