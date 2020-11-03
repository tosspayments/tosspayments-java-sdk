package com.tosspayments.sample;

import com.tosspayments.TossPayments;
import com.tosspayments.api.domain.CardPromotion;
import com.tosspayments.api.domain.PaymentDetail;
import com.tosspayments.api.param.PaymentsConfirmParams;
import com.tosspayments.exception.TossPaymentsResponseException;

import java.util.List;

public class Sample {
    public static void main(String[] args) {
        // Initialize Sdk
        TossPayments sdk = TossPayments.Builder
                .of("test_ak_ZORzdMaqN3wQd5k6ygr5AkYXQGwy")
                .build();

        try {
            // Retrieve Card Promotions
            List<CardPromotion> results = sdk.getPaymentsApi().getCardPromotions();
            for (CardPromotion cardPromotion : results) {
                System.out.println(cardPromotion.getCardCompany());
                System.out.println(cardPromotion.getDiscountAmount());
                System.out.println(cardPromotion.getDiscountCode());
            }

            // Get Payment
            PaymentDetail result = sdk.getPaymentsApi().get("6MKlA4XDvdYoEjb0gm23P1XaXWpB4VpGwBJn5eya1RPQkx9q");
            System.out.println(result.getStatus());

            // Confirm Payment
            sdk.getPaymentsApi().confirm("6MKlA4XDvdYoEjb0gm23P1XaXWpB4VpGwBJn5eya1RPQkx9q",
                    PaymentsConfirmParams.of("tviva2020110217155290114", 1000L));

        } catch (TossPaymentsResponseException e) {
            // Handle Error
            System.out.println(e.getError().getCode());
            System.out.println(e.getError().getMessage());
        }
    }
}
