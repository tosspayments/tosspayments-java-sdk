package com.tosspayments.api.model;

public class GiftCertificateConfirm {
    private String approveNo;
    private String settlementStatus;

    public GiftCertificateConfirm() {
    }

    public String getApproveNo() {
        return approveNo;
    }

    public void setApproveNo(String approveNo) {
        this.approveNo = approveNo;
    }

    public String getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(String settlementStatus) {
        this.settlementStatus = settlementStatus;
    }
}
