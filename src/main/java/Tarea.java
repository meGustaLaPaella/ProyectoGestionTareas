import Resultados.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Tarea {
    private String titulo;
    private String descripcion;
    private ArrayList<Persona> personasAsignadas;
    private String responsable;
    private int prioridad;
    private Date fechaCreacion;
    private Date fechaFinalizacion;
    private boolean esFinalizada;
    private ResultadoTarea resultado;
    private ArrayList<String> etiquetas;


    public Tarea(String titulo, String descripcion, String responsable, int prioridad){
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.responsable=responsable;
        this.prioridad=prioridad;
        this.fechaCreacion= new Date();
        this.esFinalizada=false;
        this.personasAsignadas=new ArrayList<Persona>();
    }
    public void setResultado(ResultadoTarea resultado){
        this.resultado=resultado;
    }
    public void finalizarTarea(){
        esFinalizada=true;
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
    public String mostrarPersonasAsignadas(){
        String personas = "";
        if(personasAsignadas.size()>0) {
            for (Persona persona : personasAsignadas) {
                personas += "\n" + persona.getNombre();
            }
        } else personas="No hay personas asignadas";
        return personas;
    }
    public String getTitulo(){
        return titulo;
    }
    public String mostrarTarea(){
        return "Título de la tarea: " + titulo
        + "\nResponsable: " + responsable
        + "\nPersonas asignadas: \n" + mostrarPersonasAsignadas()
        + "\n" + (esFinalizada?"Tarea finalizada.":"Tarea sin finalizar")
        + "\n" + resultado.mostrarResultado() +"\n";
    }
}
