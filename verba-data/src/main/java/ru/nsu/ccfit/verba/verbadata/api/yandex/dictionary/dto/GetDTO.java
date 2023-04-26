package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetDTO {
    @SerializedName("def")
    public ArrayList<Definition> definitions;

    public class Definition {
        public String text;//слово
        @SerializedName("pos")
        public String partOfSpeech;//часть речи
        @SerializedName("ts")
        public String transcription;//транскрипция
        @SerializedName("tr")
        public ArrayList<Translate> translates;//массив переводов

    }
    public class Example{   
        public String text;//пример
        @SerializedName("tr")
        public ArrayList<Translate> translates;//массив переводов
    }
    public static class Mean{
        public String text;//значение
    }
    public static class Synonym{
        public String text;//синоним
    }
    public class Translate {
        public String text;//перевод
        @SerializedName("pos")
        public String partOfSpeech;//часть речи
        public ArrayList<Synonym> syn;//массив синонимов
        public ArrayList<Mean> mean;//массив значений
        public ArrayList<Example> ex;//массив примеров

    }

}










