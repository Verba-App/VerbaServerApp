package ru.nsu.ccfit.verba.dataapiverba;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface YandexApi {
    @GET("/api/v1/dicservice.json/lookup")
    Call<GetGTO> getData(@Query("key") String key, @Query("lang") String lang, @Query("text") String text, @Query("ui") String ui);
}
