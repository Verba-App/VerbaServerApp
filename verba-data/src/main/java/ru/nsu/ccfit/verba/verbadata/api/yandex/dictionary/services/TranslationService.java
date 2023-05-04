package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.InfoWordDto;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.TranslateDto;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.YandexTranslateDto;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.inter.YandexApi;


import java.io.IOException;
import java.util.ArrayList;

@Service
public class TranslationService {
    @Autowired
    private YandexApi service;


    public ArrayList<TranslateDto> translateWord(String langUser, String langFrom, String langTo, String text) throws IOException {
        Call<YandexTranslateDto> retrofitCall = service.infoWords(langFrom + "-" + langTo, text, langFrom);
        Response<YandexTranslateDto> responseInfo = retrofitCall.execute();
        YandexTranslateDto dicResult = responseInfo.body();
        if (dicResult == null) {
            return null;
        }
        ArrayList<TranslateDto> response = new ArrayList<>();
        if (dicResult.definitions != null) {
            for (YandexTranslateDto.Definition article : dicResult.definitions) {
                if (article.translates != null) {
                    for (YandexTranslateDto.Translate translate : article.translates) {
                        response.add(new TranslateDto(translate.text, translate.partOfSpeech));
                    }
                }
            }
        }
        return response;
    }

    public InfoWordDto infoWord(String langUser, String langFrom, String langTo, String text) throws IOException {
        InfoWordDto response = new InfoWordDto();
        Call<YandexTranslateDto> retrofitCall = service.infoWords(langFrom + "-" + langTo, text, langFrom);
        Response<YandexTranslateDto> responseInfo = retrofitCall.execute();
        YandexTranslateDto dicResult = responseInfo.body();
        ArrayList<YandexTranslateDto.Example> examples = new ArrayList<YandexTranslateDto.Example>();
        ArrayList<YandexTranslateDto.Synonym> synonyms = new ArrayList<YandexTranslateDto.Synonym>();
        if (dicResult.definitions != null) {
            for (YandexTranslateDto.Definition article : dicResult.definitions) {
                response.transcription = article.transcription;
                if (article.translates != null) {
                    for (YandexTranslateDto.Translate translate : article.translates) {
                        if (translate.syn!=null)
                            synonyms.addAll(translate.syn);
                        if (translate.ex!=null)
                            examples.addAll(translate.ex);
                    }
                }
            }
        }
        response.synonyms=synonyms;
        response.examples=examples;
        return response;
    }
}
