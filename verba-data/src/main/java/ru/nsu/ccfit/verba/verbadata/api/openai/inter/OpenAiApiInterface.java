package ru.nsu.ccfit.verba.verbadata.api.openai.inter;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import retrofit2.http.Query;
import ru.nsu.ccfit.verba.verbadata.api.openai.dto.GeneratorRequestDto;
import ru.nsu.ccfit.verba.verbadata.api.openai.dto.GeneratorResponseDto;

import java.util.List;
import java.util.Map;


public interface OpenAiApiInterface {

    @POST("v1/images/generations")
    Call<GeneratorResponseDto> generate(@Body GeneratorRequestDto request);

}