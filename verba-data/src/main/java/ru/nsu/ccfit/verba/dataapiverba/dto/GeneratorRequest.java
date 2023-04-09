package ru.nsu.ccfit.verba.dataapiverba.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GeneratorRequest {
    private String prompt;
    private Integer n;
    private String size;
    private String response_format;
    private String user;
}
