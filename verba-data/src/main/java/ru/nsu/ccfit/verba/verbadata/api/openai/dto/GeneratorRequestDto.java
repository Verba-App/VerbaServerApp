package ru.nsu.ccfit.verba.verbadata.api.openai.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GeneratorRequestDto {
    private String prompt;
    private Integer n;
    private String size;
    private String response_format;
    private String user;
}
