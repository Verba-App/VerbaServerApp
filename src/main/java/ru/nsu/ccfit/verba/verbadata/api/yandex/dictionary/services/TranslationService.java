package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.RequestDTO;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.TranslateDTO;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.GetDTO;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.inter.YandexApi;


import java.io.IOException;
import java.util.ArrayList;

@Service
public class TranslationService {
    @Autowired
    private YandexApi service;

    private GetDTO parseJson(RequestDTO request) throws IOException{
        final GetDTO[] body = new GetDTO[1];
        service.getData(request).enqueue(new Callback<GetDTO>() {
            @Override
            public void onResponse(Call<GetDTO> call, Response<GetDTO> response) {
                if (response.body()!=null) {
                    body[0] =response.body();
                }
            }
            @Override
            public void onFailure(Call<GetDTO> call, Throwable t) {
                System.out.println("ERROR");
                body[0]=null;
            }
        });
        return body[0];

    }

    public ArrayList<TranslateDTO> translateWord(RequestDTO request) throws IOException {
        GetDTO dicResult= parseJson(request);
        ArrayList<TranslateDTO> response=new ArrayList<>();
        if (dicResult.definitions != null) {
            for (GetDTO.Definition article: dicResult.definitions) {
                if (article.translates != null) {
                    for (GetDTO.Translate translate: article.translates) {
                        GetDTO dicResult2=parseJson(new RequestDTO(request.langUser,request.langFrom,request.langTo, translate.text));
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