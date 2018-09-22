package com.example.user.vandrova.networking;

import com.example.user.vandrova.Constants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceAPIFactory {



    private final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private final Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(new EnvelopingConverter())
            .addConverterFactory(GsonConverterFactory.create());

    private final Interceptor apiKeyInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            final Request original = chain.request();
            final HttpUrl originalHttpUrl = original.url();

            final HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter("client_id", Constants.CLIENT_ID)
                    .addQueryParameter("client_secret", Constants.CLIENT_SECRET)
                    .addQueryParameter("v", "20171122")
                    .addQueryParameter("intent", "checkin")
                    .addQueryParameter("radius", "2500")
//                    .addQueryParameter("ll", "32.070080,34.794145")
                    .build();

            final Request.Builder requestBuilder = original.newBuilder().url(url);
            final Request request = requestBuilder.build();

            return chain.proceed(request);
        }
    };

    private final Retrofit retrofit = builder.client(httpClient.addInterceptor(apiKeyInterceptor).build()).build();



    public PlaceAPI placeAPI = retrofit.create(PlaceAPI.class);

}
