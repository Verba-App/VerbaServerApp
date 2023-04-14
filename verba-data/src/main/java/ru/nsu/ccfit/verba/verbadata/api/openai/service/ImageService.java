package ru.nsu.ccfit.verba.verbadata.api.openai.service;

import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;
import retrofit2.Response;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.verba.verbadata.api.openai.dto.GeneratorRequestDto;
import ru.nsu.ccfit.verba.verbadata.api.openai.inter.OpenAiApiInterface;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    private OpenAiApiInterface service;


    public String generateImage(GeneratorRequestDto request) throws IOException {
        Call<String> retrofitCall = service.generate(request);

        Response<String> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }


}
