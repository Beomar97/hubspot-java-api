package ch.marcoforster.libraries.hubspot.interceptors;

import lombok.val;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

public class RequestHeaderInterceptor implements Interceptor {

    private final String name;
    private final String value;

    public RequestHeaderInterceptor(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        val request = chain.request();
        val requestWithHeader = request.newBuilder()
                .addHeader(name, value)
                .build();

        return chain.proceed(requestWithHeader);
    }
}
