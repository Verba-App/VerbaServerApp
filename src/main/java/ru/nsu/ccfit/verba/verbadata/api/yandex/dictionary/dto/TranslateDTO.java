package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto;

public class TranslateDTO {
    public String translate;//перевод
    public String partOfSpeech;//часть речи
    public String transcription;//транскрипция

    public TranslateDTO(String translate, String partOfSpeech, String transcription) {
        this.translate = translate;
        this.partOfSpeech = partOfSpeech;
        this.transcription = transcription;
    }
}
