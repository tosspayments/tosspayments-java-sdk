package com.tosspayments.api.common;

import com.google.gson.Gson;
import com.tosspayments.api.PaymentsApi;
import com.tosspayments.exception.TossPaymentsClientException;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class TossPaymentsRequest {
    // Request
    private final URL url;
    private final Method method;
    private final TossPaymentsRequestBody body;

    // Response
    private final boolean isList;
    private final Class<? extends TossPaymentsResponseBody> objectClassType;
    private final Class<? extends TossPaymentsResponseBody[]> listClassType;

    private TossPaymentsRequest(URL url,
                                Method method,
                                TossPaymentsRequestBody body,
                                boolean isList,
                                Class<? extends TossPaymentsResponseBody> objectClassType,
                                Class<? extends TossPaymentsResponseBody[]> listClassType) {
        this.url = url;
        this.method = method;
        this.body = body;
        this.isList = isList;
        this.objectClassType = objectClassType;
        this.listClassType = listClassType;
    }

    private static URL createUrl(String host, String path, String[] pathVariables) throws TossPaymentsClientException {
        int offset = 0;
        while (offset < pathVariables.length) {
            String replaced = String.format("{%d}", offset);
            path = path.replace(replaced, pathVariables[offset++]);
        }
        try {
            return new URL(host + path);
        } catch (MalformedURLException e) {
            throw new TossPaymentsClientException(e.getMessage());
        }
    }

    public static TossPaymentsRequest ofList(String host, PaymentsApi.Endpoint endpoint,
                                         TossPaymentsRequestBody body,
                                         Class<? extends TossPaymentsResponseBody[]> listClassType,
                                         String... pathVariables) throws TossPaymentsClientException {


        return new TossPaymentsRequest(
                createUrl(host, endpoint.getPath(), pathVariables),
                endpoint.getMethod(),
                body,
                true,
                null,
                listClassType
        );
    }

    public static TossPaymentsRequest ofObject(String host, PaymentsApi.Endpoint endpoint,
                                         TossPaymentsRequestBody body,
                                         Class<? extends TossPaymentsResponseBody> objectClassType,
                                         String... pathVariables) throws TossPaymentsClientException {


        return new TossPaymentsRequest(
                createUrl(host, endpoint.getPath(), pathVariables),
                endpoint.getMethod(),
                body,
                false,
                objectClassType,
                null
        );
    }

    public URL getUrl() {
        return this.url;
    }

    public String getMethodName() {
        return this.method.name();
    }

    public boolean isList() {
        return this.isList;
    }

    public boolean existsBody() {
        return this.body != null;
    }

    public byte[] getBodyBytes(Gson gson) {
        return gson.toJson(body).getBytes(StandardCharsets.UTF_8);
    }

    public Class<? extends TossPaymentsResponseBody> getObjectClassType() {
        return objectClassType;
    }

    public Class<? extends TossPaymentsResponseBody[]> getListClassType() {
        return listClassType;
    }

    public enum Method {
        GET, POST;
    }
}