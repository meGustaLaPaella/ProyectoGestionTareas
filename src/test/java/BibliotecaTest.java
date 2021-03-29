import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    @org.junit.jupiter.api.Test
    void getLenguajeEmpleado()  {
        Proyecto proyecto= new Proyecto();
        Persona persona=new Persona("Carlos", "carlos@gmail.com");
        Persona persona2=new Persona("Pepe", "pepe@gmail.com");
        Tarea tarea= new Tarea("Cagar", "Cagar en el monte", "20959534W", 1);
        proyecto.anyadirTarea(tarea);
        proyecto.anyadirPersona(persona);
        proyecto.anyadirPersona(persona2);
        proyecto.anyadirPersonaATarea(persona, tarea);
        proyecto.anyadirPersonaATarea(persona2, tarea);
        proyecto.eliminarPersonaDeTarea(persona, tarea);
        assertFalse(tarea.getPersonasAsignadas().contains(persona));
        assertTrue(tarea.getPersonasAsignadas().contains(persona2));

    }

    @org.junit.jupiter.api.Test
    void setLenguajeEmpleado() {
    }

    @org.junit.jupiter.api.Test
    void getNumLineas() {
    }

    @org.junit.jupiter.api.Test
    void setNumLineas() {
    }

    @org.junit.jupiter.api.Test
    void getNumModulos() {
    }

    @org.junit.jupiter.api.Test
    void setNumModulos() {
    }
}