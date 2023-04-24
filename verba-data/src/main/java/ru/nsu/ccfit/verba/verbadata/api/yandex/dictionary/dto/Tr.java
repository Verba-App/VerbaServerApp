package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto;

import java.util.ArrayList;

public class Tr {
    public String text;//перевод
    public String ts;//транскрипция(не работает)
    public String pos;//часть речи
    public ArrayList<Syn> syn;//массив синонимов
    public ArrayList<Mean> mean;//массив значений
    public ArrayList<Ex> ex;//массив примеров

}
