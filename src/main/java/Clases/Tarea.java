package Clases;

import Listas.tieneLista;
import Resultados.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tarea implements tieneLista {
    private String titulo;
    private String descripcion;
    private ArrayList<Persona> personasAsignadas;
    private String responsable;
    private int prioridad;
    private Date fechaCreacion;
    private Date fechaFinalizacion;

    public boolean isEsFinalizada() {
        return esFinalizada;
    }

    private boolean esFinalizada;
    private ResultadoTarea resultado;
    private Etiquetas etiquetas;

    public ResultadoTarea getResultado() {
        return resultado;
    }

    public String getResponsable() {
        return responsable;
    }

    public Tarea(String titulo, String descripcion, String responsable, int prioridad){
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.responsable=responsable;
        this.prioridad=prioridad;
        this.fechaCreacion= new Date();
        this.esFinalizada=false;
        this.personasAsignadas=new ArrayList<Persona>();
        this.etiquetas=new Etiquetas();
    }
    public void setResultado(ResultadoTarea resultado){
        this.resultado=resultado;
    }

    public void finalizarTarea(){
        esFinalizada=true;
        fechaFinalizacion=new Date();
    }

    public ArrayList<Persona> getPersonasAsignadas(){
        return personasAsignadas;
    }

    public void anyadirPersonasAsignadas(Persona persona){
        this.personasAsignadas.add(persona);
    }

    public void eliminarPersonasAsignadas(Persona persona){
        this.personasAsignadas.remove(persona);
    }

    public void añadirEtiqueta(String etiqueta){
        etiquetas.añadirEtiqueta(etiqueta);
    }
    public ArrayList<String> getEtiquetas(){
        return etiquetas.getEtiquetas();
    }


    public String getTitulo(){
        return titulo;
    }

    @Override
    public List getLista() {
        return personasAsignadas;
    }
}
