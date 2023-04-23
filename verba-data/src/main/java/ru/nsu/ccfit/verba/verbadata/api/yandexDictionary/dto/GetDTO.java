package ru.nsu.ccfit.verba.verbadata.api.yandexDictionary.dto;
import java.util.ArrayList;

public class GetDTO {
    public ArrayList<Def> def;
}

class Ex{
    public String text;//пример
    public ArrayList<Tr> tr;//перевод примеров
}



class Mean{
    public String text;//значение
}



class Syn{
    public String text;//синоним
}

