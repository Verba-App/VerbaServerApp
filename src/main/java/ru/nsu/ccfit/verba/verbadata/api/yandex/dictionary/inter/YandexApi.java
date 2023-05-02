package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.inter;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.GetDTO;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.RequestDTO;

public interface YandexApi {
    @GET("/api/v1/dicservice.json/lookup")
    Call<GetDTO> getData(@Body RequestDTO request);
}
