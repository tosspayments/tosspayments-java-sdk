package com.tosspayments.api.model;

public class RefundReceiveAccount {
    private BankCode bank;
    private String accountNumber;
    private String holderName;

    public RefundReceiveAccount(BankCode bank, String accountNumber, String holderName) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.holderName = holderName;
    }
}
