package ru.nsu.ccfit.verba.dataapiverba.services;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import ru.nsu.ccfit.verba.dataapiverba.dto.GeneratorRequest;

public interface ImageGeneratorInterface {

    @POST("v1/images/generations")
    Call<String> generate(@Header("Content-Type") String contentType,
                                    @Header("Authorization") String apiKey,
                                    @Body GeneratorRequest request);
}