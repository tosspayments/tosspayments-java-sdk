package com.tosspayments.api.model;

public class PaymentCancelDetail {
    private Long cancelAmount;
    private String cancelReason;
    private Long taxFreeAmount;
    private Long taxAmount;
    private Long refundableAmount;
    private String canceledAt;

    public PaymentCancelDetail() {
    }

    public Long getCancelAmount() {
        return cancelAmount;
    }

    public void setCancelAmount(Long cancelAmount) {
        this.cancelAmount = cancelAmount;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Long getTaxFreeAmount() {
        return taxFreeAmount;
    }

    public void setTaxFreeAmount(Long taxFreeAmount) {
        this.taxFreeAmount = taxFreeAmount;
    }

    public Long getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Long taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Long getRefundableAmount() {
        return refundableAmount;
    }

    public void setRefundableAmount(Long refundableAmount) {
        this.refundableAmount = refundableAmount;
    }

    public String getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(String canceledAt) {
        this.canceledAt = canceledAt;
    }
}
