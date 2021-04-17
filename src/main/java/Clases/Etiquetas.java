package Clases;

import java.util.ArrayList;

public class Etiquetas {
    private ArrayList<String> etiquetas;

    public Etiquetas(){
        this.etiquetas=new ArrayList<String>();
    }
    public void añadirEtiqueta(String etiqueta){
        if(etiqueta!="") {
            this.etiquetas.add(etiqueta);
        }
    }
    public ArrayList<String> getEtiquetas(){
        return this.etiquetas;
    }

    public boolean contieneEtiqueta(String etiqueta){
        return this.etiquetas.contains(etiqueta);
    }

}
