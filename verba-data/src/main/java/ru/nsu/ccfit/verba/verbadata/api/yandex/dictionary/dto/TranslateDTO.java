package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto;
public class TranslateDTO {
    String text;//перевод
    String pos;//часть речи
    String ts;//транскрипция

    public TranslateDTO(String text, String pos, String ts) {
        this.text = text;
        this.pos = pos;
        this.ts = ts;
    }
}