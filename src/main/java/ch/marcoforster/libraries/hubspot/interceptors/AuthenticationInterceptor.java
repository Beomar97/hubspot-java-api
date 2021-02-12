package ch.marcoforster.libraries.hubspot.interceptors;

import lombok.val;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

public class AuthenticationInterceptor implements Interceptor {

    private static final String API_KEY_PARAMETER_NAME = "hapikey";

    private final String apiKey;

    public AuthenticationInterceptor(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        val request = chain.request();

        val originalUrl = request.url();
        val urlWithApiKey = originalUrl.newBuilder()
                .addQueryParameter(API_KEY_PARAMETER_NAME, apiKey)
                .build();

        val requestWithApiKey = request.newBuilder()
                .url(urlWithApiKey)
                .build();

        return chain.proceed(requestWithApiKey);
    }
}
