package ru.nsu.ccfit.verba.dataapiverba.services;

import retrofit2.Call;

import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.nsu.ccfit.verba.dataapiverba.dto.GeneratorRequest;

import java.io.IOException;


@Service
public class ImageGeneratorService {

    private static final String OPENAI_URL = "https://api.openai.com/";
    private static final String contentType= "application/json";
    private static final String apiKey = "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";
    private final ImageGeneratorInterface service;

    public ImageGeneratorService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(OPENAI_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ImageGeneratorInterface.class);

    }

    public String generateImage(GeneratorRequest request) throws IOException {
        Call<String> retrofitCall = service.generate(contentType,  "Bearer " + apiKey, request);

        Response<String> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }


}
