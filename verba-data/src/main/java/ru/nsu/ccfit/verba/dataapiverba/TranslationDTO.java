package ru.nsu.ccfit.verba.dataapiverba;

import java.util.ArrayList;


public record TranslationDTO(String status, ArrayList<Translate> tr) {
}

