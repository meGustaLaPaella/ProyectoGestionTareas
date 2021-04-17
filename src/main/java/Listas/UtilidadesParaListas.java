package Listas;

import java.util.ArrayList;

public class UtilidadesParaListas<E> {
    public static <E extends tieneLista> ArrayList<E> elementosConListaVacia(ArrayList<E> lista){
        ArrayList<E> listaElementosVacios=new ArrayList<>();
        for(E elemento:lista){
            if(elemento.getLista().isEmpty()){
                listaElementosVacios.add(elemento);
            }
        }
        return listaElementosVacios;
    }
    public static <E extends tieneClave> boolean sePuedeInsertarENListaAsociada(E objeto, E lista){









        return true;
    }
}
