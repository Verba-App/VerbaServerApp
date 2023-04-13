package ru.nsu.ccfit.verba.verbadata.api.openai.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.nsu.ccfit.verba.verbadata.api.openai.inter.OpenAiApiInterface;


@Configuration
public class OpenAiConfig {

    @Value("${api.openai.url}")
    private String OPENAI_URL ;



    @Bean
    public OpenAiApiInterface  init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(OPENAI_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(OpenAiApiInterface.class);

    }


}