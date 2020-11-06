package com.tosspayments.sample;

import com.tosspayments.TossPayments;
import com.tosspayments.api.model.BankCode;
import com.tosspayments.api.model.CardPromotion;
import com.tosspayments.api.model.PaymentDetail;
import com.tosspayments.api.model.RefundReceiveAccount;
import com.tosspayments.api.param.CancelParams;
import com.tosspayments.api.param.ConfirmParams;
import com.tosspayments.api.param.GetByOrderIdParams;
import com.tosspayments.api.param.GetParams;
import com.tosspayments.exception.TossPaymentsResponseException;

import java.util.List;

public class Sample {
    public static void main(String[] args) {
        // Initialize Sdk
        TossPayments sdk = new TossPayments
                .Builder("test_ak_ZORzdMaqN3wQd5k6ygr5AkYXQGwy")
                .build();

        try {
            // Retrieve Card Promotions
            List<CardPromotion> results = sdk.payments().getCardPromotions();
            for (CardPromotion cardPromotion : results) {
                System.out.println(cardPromotion.getCardCompany());
                System.out.println(cardPromotion.getDiscountAmount());
                System.out.println(cardPromotion.getDiscountCode());
            }

            // Get Payment
            PaymentDetail result = sdk.payments().get(
                    new GetParams("6MKlA4XDvdYoEjb0gm23P1XaXWpB4VpGwBJn5eya1RPQkx9q"));
            System.out.println(result.getStatus());
            System.out.println(result.getOrderId());

            // Get Payment (Order Id)
            PaymentDetail resultByOrderId = sdk.payments().getByOrderId(
                    new GetByOrderIdParams("5f9fc01dfcb30303e8c75da6"));
            System.out.println(resultByOrderId.getStatus());

            // Confirm Payment
            PaymentDetail confirmedPayment = sdk.payments().confirm(
                    new ConfirmParams.Builder(
                            "6MKlA4XDvdYoEjb0gm23P1XaXWpB4VpGwBJn5eya1RPQkx9q",
                            "5f9fc01dfcb30303e8c75da6",
                            1000L).build());

            // Cancel Payment
            PaymentDetail canceledPayment = sdk.payments().cancel(
                    new CancelParams.Builder(
                            "6MKlA4XDvdYoEjb0gm23P1XaXWpB4VpGwBJn5eya1RPQkx9q", "기타 취소")
                            .cancelAmount(500L)
                            .refundReceiveAccount(
                                    BankCode.국민,
                                    "123123451234",
                                    "홍길동"
                            ).build());

        } catch (TossPaymentsResponseException e) {
            // Handle Error
            System.out.println(e.getError().getCode());
            System.out.println(e.getError().getMessage());
        }
    }
}
