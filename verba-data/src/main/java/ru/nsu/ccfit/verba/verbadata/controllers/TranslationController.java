package ru.nsu.ccfit.verba.verbadata.controllers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.AnswerDTO;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.RequestDTO;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.TranslateDTO;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.services.TranslationService;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/translate")
public class TranslationController {
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    @Autowired
    private TranslationService translationService;

    @PostMapping("/generate")
    public String translate(@RequestBody RequestDTO request) throws IOException{
        ArrayList<TranslateDTO> translates = translationService.translateWord(request);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(new AnswerDTO("s",translates));
    }
}
