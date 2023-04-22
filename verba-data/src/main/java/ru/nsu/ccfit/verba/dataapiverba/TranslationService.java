package ru.nsu.ccfit.verba.dataapiverba;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;

@Service
public class TranslationService {
    private static final String key="dict.1.1.20230330T121731Z.05a289ace7276e75.4028b7fd809c2e8f2017a3d28d50ac7bd63202a0";
    @Autowired
    private YandexApi service;

    private  GetGTO getJson(String langUser, String langFrom, String langTo, String text) throws IOException{

       // Response<GetGTO> response = service.getData(key, langFrom+"-"+langTo,text,langUser).execute();
        final GetGTO[] body = new GetGTO[1];
        service.getData(key, langFrom+"-"+langTo,text,langUser).enqueue(new Callback<GetGTO>() {
            @Override
            public void onResponse(Call<GetGTO> call, Response<GetGTO> response) {
                if (response.body()!=null) {
                    body[0] =response.body();
                }
            }
            @Override
            public void onFailure(Call<GetGTO> call, Throwable t) {
                System.out.println("ERROR");
                body[0]=null;
            }
        });
        return body[0];

    }

    public ArrayList<Translate> translateWord(String langUser, String langFrom, String langTo, String text) throws IOException {
        GetGTO dicResult= getJson(langUser, langFrom, langTo, text);
        ArrayList<Translate> response=new ArrayList<Translate>();
        if (dicResult.def != null) {
        for (Def trans : dicResult.def) {
                if (trans.tr != null) {
                for (Tr tr : trans.tr) {
                    GetGTO dicResult2=getJson(langUser, langTo, langTo, tr.text);
                    String ts="";
                    if (dicResult2!=null&&!dicResult2.def.isEmpty()){
                        Def def=dicResult2.def.get(0);
                        ts= def.ts;
                    }
                    response.add(new Translate(tr.text,tr.pos,ts));
                    }
                }
            }
        }
        return response;
    }
}