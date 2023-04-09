package ru.nsu.ccfit.verba.dataapiverba.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class GeneratorResponse {
    private String created;
    private List<String> data;
}
