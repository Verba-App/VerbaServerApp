package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.TranslateDTO;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.GetDTO;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.inter.YandexApi;


import java.io.IOException;
import java.util.ArrayList;

@Service
public class TranslationService {
    @Autowired
    private YandexApi service;

    private GetDTO parseJson(String langUser, String langFrom, String langTo, String text) throws IOException{
        Call<GetDTO> retrofitCall = service.getData(langFrom+"-"+langTo,text,langFrom);

        Response<GetDTO> response = retrofitCall.execute();

        int a=1;
        return response.body();


    }

    public ArrayList<TranslateDTO> translateWord(String langUser, String langFrom, String langTo, String text) throws IOException {
        GetDTO dicResult= parseJson(langUser, langFrom, langTo, text);
        if (dicResult==null){
            return null;
        }
        ArrayList<TranslateDTO> response=new ArrayList<>();

        if (dicResult.definitions != null) {
            for (GetDTO.Definition article: dicResult.definitions) {
                if (article.translates != null) {
                    for (GetDTO.Translate translate: article.translates) {
                        GetDTO dicResult2=parseJson(langUser, langTo, langTo, translate.text);
                        String transcription="";
                        if (dicResult2!=null&&!dicResult2.definitions.isEmpty()){
                            GetDTO.Definition definition=dicResult2.definitions.get(0);
                            transcription= definition.transcription;
                        }
                        response.add(new TranslateDTO(translate.text,translate.partOfSpeech,transcription));
                    }
                }
            }
        }
        return response;
    }
}
