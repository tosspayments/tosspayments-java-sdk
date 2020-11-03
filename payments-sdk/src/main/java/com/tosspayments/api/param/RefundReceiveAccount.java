package com.tosspayments.api.param;

public class RefundReceiveAccount {
    private BankCode bank;
    private String accountNumber;
    private String holderName;

    private RefundReceiveAccount(BankCode bank, String accountNumber, String holderName) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.holderName = holderName;
    }

    public static RefundReceiveAccount of(BankCode bank, String accountNumber, String holderName) {
        return new RefundReceiveAccount(bank, accountNumber, holderName);
    }
}
