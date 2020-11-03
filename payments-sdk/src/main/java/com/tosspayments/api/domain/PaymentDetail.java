package com.tosspayments.api.domain;

import com.tosspayments.api.common.TossPaymentsResponseBody;
import com.tosspayments.api.domain.confirm.CardConfirm;
import com.tosspayments.api.domain.confirm.CashReceiptConfirm;
import com.tosspayments.api.domain.confirm.GiftCertificateConfirm;
import com.tosspayments.api.domain.confirm.MobilePhoneConfirm;
import com.tosspayments.api.domain.confirm.VirtualAccountConfirm;

import java.util.List;

public class PaymentDetail extends TossPaymentsResponseBody {
    private String paymentKey;
    private String orderId;
    private String mId;
    private String currency;
    private String method;
    private Long totalAmount;
    private Long balanceAmount;
    private String status;
    private String requestedAt;
    private String approvedAt;
    private Boolean useDiscount;
    private Long discountAmount;
    private Boolean useEscrow;
    private Boolean useCashReceipt;
    private String secret;

    private CardConfirm card;
    private VirtualAccountConfirm virtualAccount;
    private MobilePhoneConfirm mobilePhone;
    private GiftCertificateConfirm giftCertificate;
    private CashReceiptConfirm cashReceipt;
    private List<PaymentCancelDetail> cancels;

    public PaymentDetail() {
    }

    public String getPaymentKey() {
        return paymentKey;
    }

    public void setPaymentKey(String paymentKey) {
        this.paymentKey = paymentKey;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Long balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(String requestedAt) {
        this.requestedAt = requestedAt;
    }

    public String getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(String approvedAt) {
        this.approvedAt = approvedAt;
    }

    public Boolean getUseDiscount() {
        return useDiscount;
    }

    public void setUseDiscount(Boolean useDiscount) {
        this.useDiscount = useDiscount;
    }

    public Long getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Boolean getUseEscrow() {
        return useEscrow;
    }

    public void setUseEscrow(Boolean useEscrow) {
        this.useEscrow = useEscrow;
    }

    public Boolean getUseCashReceipt() {
        return useCashReceipt;
    }

    public void setUseCashReceipt(Boolean useCashReceipt) {
        this.useCashReceipt = useCashReceipt;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public CardConfirm getCard() {
        return card;
    }

    public void setCard(CardConfirm card) {
        this.card = card;
    }

    public VirtualAccountConfirm getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(VirtualAccountConfirm virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public MobilePhoneConfirm getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(MobilePhoneConfirm mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public GiftCertificateConfirm getGiftCertificate() {
        return giftCertificate;
    }

    public void setGiftCertificate(GiftCertificateConfirm giftCertificate) {
        this.giftCertificate = giftCertificate;
    }

    public CashReceiptConfirm getCashReceipt() {
        return cashReceipt;
    }

    public void setCashReceipt(CashReceiptConfirm cashReceipt) {
        this.cashReceipt = cashReceipt;
    }

    public List<PaymentCancelDetail> getCancels() {
        return cancels;
    }

    public void setCancels(List<PaymentCancelDetail> cancels) {
        this.cancels = cancels;
    }
}
