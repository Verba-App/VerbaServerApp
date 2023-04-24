package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto;

import java.util.ArrayList;



public record AnswerDTO(String status, ArrayList<TranslateDTO> tr) {

}

