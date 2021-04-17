package Clases;

import Listas.tieneLista;

import java.util.ArrayList;
import java.util.List;

public class Persona implements tieneLista {
    private String nombre;
    private String correo;
    private ArrayList<Tarea> listaTareas;
    private String dni;

    public Persona(){ super();}
    public Persona(String nombre, String correo, String dni){
        this.nombre=nombre;
        this.correo=correo;
        this.dni=dni;
    }
    //Añadir tareas
    public void añadirTareaAPersona(Tarea tarea){
        if(!tieneTarea(tarea)) {
            listaTareas.add(tarea);
        }
    }
    public void eliminarTareaDePersona(Tarea tarea){
        if(tieneTarea(tarea))listaTareas.remove(tarea);
    }
    public boolean tieneTarea(Tarea tarea){
        return (listaTareas.contains(tarea));
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public List getLista() {
        return listaTareas;
    }
}
