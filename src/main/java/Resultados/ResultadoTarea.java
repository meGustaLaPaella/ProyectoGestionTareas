package Resultados;

public abstract class ResultadoTarea {
    private final String identificador;
    private final int numeroEsperadoHoras;
    private final String resultadoInternoExterno;

    public ResultadoTarea(String identificador, int numeroEsperadoHoras, String resultadoInternoExterno){
        this.identificador=identificador;
        this.numeroEsperadoHoras=numeroEsperadoHoras;
        this.resultadoInternoExterno=resultadoInternoExterno;
    }

    public String getIdentificador() {
        return identificador;
    }

    public int getNumeroEsperadoHoras() {
        return numeroEsperadoHoras;
    }

    public String getResultadoInternoExterno() {
        return resultadoInternoExterno;
    }

    public abstract String mostrarResultado();
}
