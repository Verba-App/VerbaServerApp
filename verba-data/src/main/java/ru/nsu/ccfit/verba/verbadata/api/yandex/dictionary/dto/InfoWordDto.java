package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class InfoWordDto {
    public ArrayList<YandexTranslateDto.Synonym> synonyms;//массив синонимов
    public ArrayList<YandexTranslateDto.Example> examples;//массив примеров
    public String transcription;//транскрипция
}
