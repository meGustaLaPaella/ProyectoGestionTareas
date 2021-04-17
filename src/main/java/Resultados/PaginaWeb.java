package Resultados;

public class PaginaWeb extends ResultadoTarea{
    private String estaticaDinamica;
    private String lenguaje;
    private String backend;


    public PaginaWeb(String identificador, int numHoras, String tipoResultado,
                     String estaticaDinamica, String lenguaje, String backend) {
        super(identificador,numHoras,tipoResultado);
        this.estaticaDinamica=estaticaDinamica;
        this.lenguaje=lenguaje;
        this.backend=backend;
    }


    @Override
    public String mostrarResultadoEspecifico(){
        return "\n\tTipo:     " + estaticaDinamica
                + "\n\tLenguaje: " + lenguaje
                + "\n\tBack end: " + backend;
    }

}
