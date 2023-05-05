package ru.nsu.ccfit.verba.verbadata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.InfoWordDto;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto.TranslateDto;
import ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.services.TranslationService;
import ru.nsu.ccfit.verba.verbadata.platform.ResponseDto;

import java.util.ArrayList;

@RestController
@RequestMapping("/words")
public class TranslationController {
    @Autowired
    private TranslationService translationService;

    @PostMapping("/translate")
    public ResponseDto<ArrayList<TranslateDto>> translate(@RequestParam String text, @RequestParam String lang) throws Exception{
        ArrayList<TranslateDto> translates = translationService.translateWord(lang, lang, "en", text);
        return ResponseDto.withData(translates);
    }
    @PostMapping("/info")
    public ResponseDto<InfoWordDto> info(@RequestParam String text, @RequestParam String lang) throws Exception {
        InfoWordDto wordInfo = translationService.infoWord(lang, lang, "en", text);
        return   ResponseDto.withData(wordInfo);
    }
}
