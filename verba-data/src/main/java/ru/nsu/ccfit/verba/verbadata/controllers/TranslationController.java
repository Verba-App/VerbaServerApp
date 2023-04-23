package ru.nsu.ccfit.verba.verbadata.controllers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.verba.verbadata.api.yandexDictionary.dto.AnswerDTO;
import ru.nsu.ccfit.verba.verbadata.api.yandexDictionary.dto.TranslateDTO;
import ru.nsu.ccfit.verba.verbadata.api.yandexDictionary.services.TranslationService;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class TranslationController {
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    @Autowired
    private TranslationService translationService;

    @PostMapping("/translate")
    public String translate(@RequestParam String text, @RequestParam String lang) throws IOException{
        ArrayList<TranslateDTO> translates = translationService.translateWord(lang, lang, "en", text);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(new AnswerDTO("s",translates));
    }
}
