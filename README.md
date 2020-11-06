# TossPayments REST API Java SDK

This repository contains Java SDK and samples for REST API.

## Prerequisites
- Java JDK 7 or higher
- An environment which supports TLS 1.2 (see the TLS-update site for more information)

## Installation
#### Download Jar
- latest version: [0.1](https://github.com/tosspayments/tosspayments-java-sdk/raw/master/libs/payments-sdk-0.1-all.jar)


## Usage
#### Sample Code

- Initialize SDK
```
import com.tosspayments.TossPayments;

...

// Initialize Sdk
TossPayments sdk = new TossPayments.Builder("test_ak_ZORzdMaqN3wQd5k6ygr5AkYXQGwy")
    .withReadTimeout(100000)
    .build();
```

- Request Api (Confirm Payment API)
```
// Confirm Payment
PaymentDetail confirmedResult = sdk.payments().confirm(
        new ConfirmParams.Builder(paymentKey, orderId, amount).build()
);
```
