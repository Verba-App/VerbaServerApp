package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto;

import java.util.ArrayList;
public record TranslationWordsDto(String status, ArrayList<TranslateDto> tr){}

