package ru.nsu.ccfit.verba.verbadata.api.yandexDictionary.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.nsu.ccfit.verba.verbadata.api.yandexDictionary.dto.TranslateDTO;
import ru.nsu.ccfit.verba.verbadata.api.yandexDictionary.dto.GetDTO;
import ru.nsu.ccfit.verba.verbadata.api.yandexDictionary.dto.Def;
import ru.nsu.ccfit.verba.verbadata.api.yandexDictionary.dto.Tr;
import ru.nsu.ccfit.verba.verbadata.api.yandexDictionary.inter.YandexApi;


import java.io.IOException;
import java.util.ArrayList;

@Service
public class TranslationService {
    private static final String key="dict.1.1.20230330T121731Z.05a289ace7276e75.4028b7fd809c2e8f2017a3d28d50ac7bd63202a0";
    @Autowired
    private YandexApi service;

    private GetDTO getJson(String langUser, String langFrom, String langTo, String text) throws IOException{
        final GetDTO[] body = new GetDTO[1];
        service.getData(key, langFrom+"-"+langTo,text,langUser).enqueue(new Callback<GetDTO>() {
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

    public ArrayList<TranslateDTO> translateWord(String langUser, String langFrom, String langTo, String text) throws IOException {
        GetDTO dicResult= getJson(langUser, langFrom, langTo, text);
        ArrayList<TranslateDTO> response=new ArrayList();
        if (dicResult.def != null) {

        for (Def trans : dicResult.def) {
                if (trans.tr != null) {
                for (Tr tr : trans.tr) {
                    GetDTO dicResult2=getJson(langUser, langTo, langTo, tr.text);
                    String ts="";
                    if (dicResult2!=null&&!dicResult2.def.isEmpty()){
                        Def def=dicResult2.def.get(0);
                        ts= def.ts;
                    }
                    response.add(new TranslateDTO(tr.text,tr.pos,ts));
                    }
                }
            }
        }
        return response;
    }
}