package com.tosspayments.network;

import com.tosspayments.exception.TossPaymentsClientException;
import com.tosspayments.util.EncodingUtils;

import java.io.UnsupportedEncodingException;

public class HttpBasicAuthProvider {
    private final String secretKey;
    private final String authorizations;

    public HttpBasicAuthProvider(String secretKey) {
        try {
            this.secretKey = secretKey;
            this.authorizations = "Basic " + EncodingUtils.encodeBase64(getBasicAuthContents());
        } catch (UnsupportedEncodingException e) {
            throw new TossPaymentsClientException(e.getMessage());
        }
    }

    private String getBasicAuthContents() {
        return secretKey + ":";
    }

    public String getAuthorizations() {
        return this.authorizations;
    }
}
