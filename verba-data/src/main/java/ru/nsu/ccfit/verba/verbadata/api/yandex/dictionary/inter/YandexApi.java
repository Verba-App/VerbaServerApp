package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.inter;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.GetDTO;

public interface YandexApi {
    @GET("/api/v1/dicservice.json/lookup")
    Call<GetDTO> getData(@Query("key") String key, @Query("lang") String lang, @Query("text") String text, @Query("ui") String ui);
}
