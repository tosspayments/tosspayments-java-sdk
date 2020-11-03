# TossPayments REST API Java SDK

This repository contains Java SDK and samples for REST API.

## Prerequisites
- Java JDK 6 or higher
- An environment which supports TLS 1.2 (see the TLS-update site for more information)

## Installation
#### Download Jar
- latest version: [0.1](https://github.com/tosspayments/tosspayments-java-sdk/raw/master/libs/payments-sdk-0.1-RC-all.jar)


## Usage
#### Sample Code

- Initialize SDK
```
import com.tosspayments.TossPayments;

...

// Initialize Sdk
TossPayments sdk = TossPayments.Builder
        .of("test_ak_ZORzdMaqN3wQd5k6ygr5AkYXQGwy")
        .build();
```

- Request Api (Confirm Payment API)
```
// Confirm Payment
sdk.getPaymentsApi().confirm("6MKlA4XDvdYoEjb0gm23P1XaXWpB4VpGwBJn5eya1RPQkx9q",
        PaymentsConfirmParams.of("tviva2020110217155290114", 1000L));
```
