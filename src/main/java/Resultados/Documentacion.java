package Resultados;

public class Documentacion extends ResultadoTarea {
    private String formato;
    private int numPaginas;
    private double espacioEnDisco;

    public Documentacion(String identificador, int numHoras, String tipoResultado,
                         String formato, int numPaginas, double espacioEnDisco){
        super(identificador,numHoras,tipoResultado);
        this.formato=formato;
        this.numPaginas=numPaginas;
        this.espacioEnDisco=espacioEnDisco;
    }


    @Override
    public String mostrarResultado(){
        return "Resultado: \"" + getIdentificador() + "\" de duración " +
                getNumeroEsperadoHoras() + " horas, (" + getResultadoInternoExterno() + ")"
                + "\n\tFormato:           " + formato
                + "\n\tNúmero de Páginas: " + numPaginas
                + "\n\tEspacio en disco:  " + espacioEnDisco;
    }
}
