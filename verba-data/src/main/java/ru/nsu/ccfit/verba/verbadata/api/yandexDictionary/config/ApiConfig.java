package ru.nsu.ccfit.verba.verbadata.api.yandexDictionary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.nsu.ccfit.verba.verbadata.api.yandexDictionary.inter.YandexApi;

@Configuration
public class ApiConfig {
    @Bean
    public YandexApi onCreate(){
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://dictionary.yandex.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(YandexApi.class);
    }
}
