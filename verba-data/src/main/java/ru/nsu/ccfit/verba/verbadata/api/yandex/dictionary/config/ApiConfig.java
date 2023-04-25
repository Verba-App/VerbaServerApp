package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.config;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.inter.YandexApi;

import java.io.IOException;

@Configuration
public class ApiConfig {

    @Value("${api.yandex.url}")
    private String YANDEX_URL ;
    @Value("${api.yandex.api-key}")
    private String apiKey ;
    @Bean
    public YandexApi onCreate(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                HttpUrl originalHttpUrl = originalRequest.url();

                HttpUrl modifiedUrl = originalHttpUrl.newBuilder()
                        .addQueryParameter("langUser", "langUser")
                        .addQueryParameter("langFrom", "langFrom")
                        .addQueryParameter("langTo", "langTo")
                        .addQueryParameter("word", "word")
                        .build();

                Request modifiedRequest = originalRequest.newBuilder()
                        .addHeader("Authorization", apiKey)
                        .url(modifiedUrl)
                        .build();

                return chain.proceed(modifiedRequest);
            }
        });







        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(YANDEX_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(YandexApi.class);
    }
}
