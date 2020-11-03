package com.tosspayments.api.domain.confirm;

public class CashReceiptConfirm {
    private String type;
    private Long amount;
    private Long taxFreeAmount;
    private String issueNumber;
    private String receiptUrl;

    public CashReceiptConfirm() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getTaxFreeAmount() {
        return taxFreeAmount;
    }

    public void setTaxFreeAmount(Long taxFreeAmount) {
        this.taxFreeAmount = taxFreeAmount;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getReceiptUrl() {
        return receiptUrl;
    }

    public void setReceiptUrl(String receiptUrl) {
        this.receiptUrl = receiptUrl;
    }
}
