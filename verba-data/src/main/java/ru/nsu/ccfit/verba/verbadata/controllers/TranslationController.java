package ru.nsu.ccfit.verba.verbadata.controllers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.TranslationWordsDto;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.InfoWordDto;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.TranslateDto;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.services.TranslationService;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/words")
public class TranslationController {
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    @Autowired
    private TranslationService translationService;

    @PostMapping("/translate")
    public String translate(@RequestParam String text, @RequestParam String lang) throws IOException{
        ArrayList<TranslateDto> translates = translationService.translateWord(lang, lang, "en", text);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        if (translates==null){
            return gson.toJson(new TranslationWordsDto(ERROR_STATUS,null));
        }
        return gson.toJson(new TranslationWordsDto(SUCCESS_STATUS,translates));
    }
    @PostMapping("/info")
    public String info(@RequestParam String text, @RequestParam String lang) throws IOException {
        InfoWordDto wordInfo = translationService.infoWord(lang, lang, "en", text);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        if (wordInfo==null){
            return gson.toJson(new TranslationWordsDto(ERROR_STATUS,null));
        }
        return gson.toJson(wordInfo);
    }
}
