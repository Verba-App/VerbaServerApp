package ru.nsu.ccfit.verba.verbadata.api.openai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import retrofit2.Call;
import retrofit2.Response;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.verba.verbadata.api.openai.dto.GeneratorRequestDto;
import ru.nsu.ccfit.verba.verbadata.api.openai.dto.ResponseDto;
import ru.nsu.ccfit.verba.verbadata.api.openai.inter.OpenAiApiInterface;

import java.io.IOException;
import java.util.List;


@Service
public class FoundService {

    @Autowired
    private OpenAiApiInterface service;

    @Value("${api.openai.n}")
    private int n;

    @Value("${api.openai.size}")
    private String size;

    @Value("${api.openai.format}")
    private String format;

    public ResponseDto<List<String>> generateImage(String request) throws IOException {

        Call<List<String>> retrofitCall = service.generate(new GeneratorRequestDto(request, n, size, format));

        Response<List<String>> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return ResponseDto.withData(response.body());
        //return response.body();
    }


}
