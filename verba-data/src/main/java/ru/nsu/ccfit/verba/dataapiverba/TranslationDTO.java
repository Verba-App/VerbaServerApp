package ru.nsu.ccfit.verba.dataapiverba;

import java.util.ArrayList;


public class TranslationDTO {
    private final String status;
    private final ArrayList<Translate> tr;



    public TranslationDTO(String status, ArrayList<Translate> tr){
        this.status=status;
        this.tr=tr;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<Translate> getTr() {
        return tr;
    }
}

