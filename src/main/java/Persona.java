import java.util.ArrayList;

public class Persona {
    private String nombre;
    private String correo;
    private ArrayList<Tarea> listaTareas;
    private String dni;

    public Persona() {
        super();
    }
    public Persona(String nombre, String correo){
        this.nombre=nombre;
        this.correo=correo;
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

}
