package ru.nsu.ccfit.verba.dataapiverba;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        ArrayList<Translate> a = translationService.translateWord(lang, lang, "en", text);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(new TranslationDTO("s",a));
    }
}
