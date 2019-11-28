package com.moringaschool.live_cleanliness.networks;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringaschool.live_cleanliness.Constants.POSTGRESQL_BASE_URL;

public class PostgresqlClient {
    private static Retrofit retrofit = null;

    public static PostgresqlAPI getClient() {


        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Interceptor.Chain chain) throws IOException {
                            Request newRequest  = chain.request().newBuilder()
//                                    .addHeader("Authorization", YELP_API_KEY)
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(POSTGRESQL_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(PostgresqlAPI.class);
    }
}
