package ch.marcoforster.libraries.hubspot;

import ch.marcoforster.libraries.hubspot.api.CrmApi;
import ch.marcoforster.libraries.hubspot.interceptors.AuthenticationInterceptor;
import lombok.val;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HubSpot {

    private static final String BASE_URL = "https://api.hubapi.com/";

    private final Retrofit retrofit;

    public HubSpot(String apiKey) {
        val okHttpClient = buildOkHttpClient(apiKey);
        val gsonConverterFactory = buildGsonConverterFactory();

        this.retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .baseUrl(BASE_URL)
                .build();
    }

    public CrmApi crmApi() {
        return retrofit.create(CrmApi.class);
    }

    private OkHttpClient buildOkHttpClient(String apiKey) {
        return new OkHttpClient().newBuilder()
                .addInterceptor(new AuthenticationInterceptor(apiKey))
                .build();
    }

    private GsonConverterFactory buildGsonConverterFactory() {
        return GsonConverterFactory.create();
    }
}