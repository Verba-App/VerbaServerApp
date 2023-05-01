package ru.nsu.ccfit.verba.verbadata.api.yandex.dictionary.dto;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RequestDto {
    public String langUser;
    public String langFrom;
    public String langTo;
    public String word;
}
