package Resultados;

public class Biblioteca extends ResultadoTarea {
    private String lenguajeEmpleado;
    private int numLineas;
    private int numModulos;

    public Biblioteca(String identificador, int numHoras, String tipoResultado,
                      String lenguajeEmpleado, int numLineas, int numModulos) {
        super(identificador,numHoras,tipoResultado);
        this.lenguajeEmpleado=lenguajeEmpleado;
        this.numLineas=numLineas;
        this.numModulos=numModulos;
    }

    @Override
    public String mostrarResultado(){
        return  "Resultado: " + getIdentificador() +
                " de duración " + getNumeroEsperadoHoras() + " horas, (" + getResultadoInternoExterno() + ")"
                + "\n\tLenguaje:          " + lenguajeEmpleado
                + "\n\tNumero de Lineas:  " + numLineas
                + "\n\tNumero de Módulos: " + numModulos;
    }
}
