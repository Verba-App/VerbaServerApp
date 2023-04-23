package ru.nsu.ccfit.verba.verbadata.api.yandexDictionary.dto;

import java.util.ArrayList;



public record AnswerDTO(String status, ArrayList<TranslateDTO> tr) {

}

