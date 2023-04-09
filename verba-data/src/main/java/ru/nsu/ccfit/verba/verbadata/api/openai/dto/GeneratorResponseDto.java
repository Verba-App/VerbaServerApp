package ru.nsu.ccfit.verba.verbadata.api.openai.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeneratorResponseDto {
    private String created;
    private List<String> data;
}
