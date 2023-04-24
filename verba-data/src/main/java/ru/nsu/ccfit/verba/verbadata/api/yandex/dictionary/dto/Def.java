package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto;

import java.util.ArrayList;

public class Def {
    public String text;//слово
    public String pos;//часть речи
    public String ts;//транскрипция
    public ArrayList<Tr> tr;//массив переводов
}
