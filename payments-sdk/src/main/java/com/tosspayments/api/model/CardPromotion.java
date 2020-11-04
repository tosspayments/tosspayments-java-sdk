package com.tosspayments.api.model;

import com.tosspayments.api.common.TossPaymentsResponseBody;

public class CardPromotion extends TossPaymentsResponseBody {
    private String cardCompany;
    private Long discountAmount;
    private String discountCode;
    private String discountDueDate;
    private Long maximumPaymentAmount;
    private Long minimumPaymentAmount;

    public CardPromotion() {
    }

    public String getCardCompany() {
        return cardCompany;
    }

    public void setCardCompany(String cardCompany) {
        this.cardCompany = cardCompany;
    }

    public Long getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getDiscountDueDate() {
        return discountDueDate;
    }

    public void setDiscountDueDate(String discountDueDate) {
        this.discountDueDate = discountDueDate;
    }

    public Long getMaximumPaymentAmount() {
        return maximumPaymentAmount;
    }

    public void setMaximumPaymentAmount(Long maximumPaymentAmount) {
        this.maximumPaymentAmount = maximumPaymentAmount;
    }

    public Long getMinimumPaymentAmount() {
        return minimumPaymentAmount;
    }

    public void setMinimumPaymentAmount(Long minimumPaymentAmount) {
        this.minimumPaymentAmount = minimumPaymentAmount;
    }
}
