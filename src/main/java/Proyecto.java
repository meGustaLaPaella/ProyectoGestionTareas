import java.util.ArrayList;
//Con HashSet mejor
public class Proyecto {
    String nombreProyecto;
    private ArrayList<Tarea> listaTareas;
    private ArrayList<Persona> listaPersonas;

    public Proyecto() {
        this.listaTareas = new ArrayList<>();
        this.listaPersonas = new ArrayList<>();
    }

    public void anyadirTarea(Tarea tarea){
        this.listaTareas.add(tarea);
    }

    public void anyadirPersona(Persona persona){
        this.listaPersonas.add(persona);
    }

    public void anyadirPersonaATarea(Persona persona, Tarea tarea){
        for(Tarea t:listaTareas){
            if(t.equals(tarea)){
                tarea.anyadirPersonasAsignadas(persona);
            }
        }
    }
    public void eliminarPersonaDeTarea(Persona persona, Tarea tarea){
        for(Tarea t:listaTareas){
            if(t.equals(tarea)){
                tarea.eliminarPersonasAsignadas(persona);
            }
        }
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
    public Tarea buscarTarea(String titulo){
        for(Tarea tarea:listaTareas){
            if(tarea.getTitulo().equals(titulo)){
                return tarea;
            }
        }
        return null;
    }
    public Persona buscarPersona(String dni){
        for(Persona persona:listaPersonas){
            if(persona.getDni().equals(dni)){
                return persona;
            }
        }
        return null;
    }

    public ArrayList<Tarea> getListaTareas() {
        return listaTareas;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }
}
