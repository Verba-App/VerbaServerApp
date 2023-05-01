package ru.nsu.ccfit.verba.verbadata.api.openai.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GeneratorResponseDto {
    //** Номер ответа */
    private Long created;

    //** Список ссылок на созданные картинки */
    private List<Url> data;

    public List<String> getStrings() {
        List<String> newList = new ArrayList<>();

        for (Url datum : data) {
            newList.add(datum.getUrl());
        }

        return newList;
    }
    @Data
    @NoArgsConstructor
    @Getter
    static class Url {
        String url;
    }
}

