package ru.nsu.ccfit.verba.dataapiverba;
import java.util.ArrayList;

public class GetGTO {
    public ArrayList<Def> def;
}
class Def {
    public String text;
    public String pos;
    public String ts;
    public ArrayList<Tr> tr;
}

class Ex{
    public String text;
    public ArrayList<Tr> tr;
}



class Mean{
    public String text;
}



class Syn{
    public String text;
}

class Tr{
    public String text;
    public String ts;
    public String pos;
    public ArrayList<Syn> syn;
    public ArrayList<Mean> mean;
    public ArrayList<Ex> ex;

}

