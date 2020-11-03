package com.tosspayments.network;

import com.google.gson.Gson;
import com.tosspayments.api.common.ErrorBody;
import com.tosspayments.api.common.TossPaymentsRequest;
import com.tosspayments.api.common.TossPaymentsResponse;
import com.tosspayments.api.common.TossPaymentsResponseBody;
import com.tosspayments.exception.TossPaymentsClientException;
import com.tosspayments.exception.TossPaymentsResponseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpClient {
    private final HttpBasicAuthProvider keyProvider;
    private final Gson gson;

    private int connectTimeout = 5000;
    private int readTimeout = 5000;

    public HttpClient(HttpBasicAuthProvider keyProvider, Gson gson) {
        this.keyProvider = keyProvider;
        this.gson = gson;
    }

    public HttpClient(HttpBasicAuthProvider keyProvider, Gson gson, int connectTimeout, int readTimeout) {
        this.keyProvider = keyProvider;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.gson = gson;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    private boolean isSuccess(HttpURLConnection connection) throws IOException {
        return connection.getResponseCode() >= 200 && connection.getResponseCode() < 300;
    }

    private String readToEnd(InputStream stream) throws IOException {
        final int bufferSize = 1024;
        final StringBuilder builder = new StringBuilder();
        final char[] buffer = new char[bufferSize];
        final Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        int charsRead;
        while ((charsRead = reader.read(buffer, 0, buffer.length)) > 0) {
            builder.append(buffer, 0, charsRead);
        }
        return builder.toString();
    }

    public TossPaymentsResponse<TossPaymentsResponseBody> request(TossPaymentsRequest request)
            throws TossPaymentsClientException, TossPaymentsResponseException {
        try {
            final HttpURLConnection connection = (HttpURLConnection) request.getUrl().openConnection();
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(readTimeout);
            connection.setUseCaches(false);
            connection.setRequestMethod(request.getMethodName());

            connection.setRequestProperty("Authorization", keyProvider.getAuthorizations());
            connection.setRequestProperty("Content-Type", "application/json");

            if (request.existsBody()) {
                connection.setDoOutput(true);
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(request.getBodyBytes(gson));
            }

            final boolean success = isSuccess(connection);
            final InputStream responseStream = success ? connection.getInputStream() : connection.getErrorStream();
            final String responseBody = readToEnd(responseStream);
            responseStream.close();

            if (success) {
                if (request.isList()) {
                    List<? extends TossPaymentsResponseBody> list
                            = new ArrayList<>(Arrays.asList(gson.fromJson(responseBody, request.getListClassType())));
                    return new TossPaymentsResponse<>(list);
                } else {
                    TossPaymentsResponseBody body = gson
                            .fromJson(responseBody, request.getObjectClassType());
                    return new TossPaymentsResponse<>(body);
                }
            } else {
                ErrorBody body = gson.fromJson(responseBody, ErrorBody.class);
                throw new TossPaymentsResponseException(body);
            }
        } catch (IOException e) {
            throw new TossPaymentsClientException(e.getMessage());
        }
    }
}
