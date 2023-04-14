package ru.nsu.ccfit.verba.verbadata.api.openai.service;

import lombok.RequiredArgsConstructor;
import retrofit2.Call;
import retrofit2.Response;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.verba.verbadata.api.openai.dto.GeneratorRequestDto;
import ru.nsu.ccfit.verba.verbadata.api.openai.inter.OpenAiApiInterface;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final OpenAiApiInterface service;


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
