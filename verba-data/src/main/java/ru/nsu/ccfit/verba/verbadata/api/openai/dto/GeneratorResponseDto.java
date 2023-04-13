package ru.nsu.ccfit.verba.verbadata.api.openai.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeneratorResponseDto {
    //** Номер ответа */
    private String created;

    //** Список ссылок на созданные картинки */
    private List<String> data;
}
