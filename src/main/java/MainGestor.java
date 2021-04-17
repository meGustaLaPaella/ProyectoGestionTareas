import Clases.Persona;
import Clases.Proyecto;
import Clases.Tarea;
import Resultados.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainGestor {
    private static String nombreProyecto;
    private static Proyecto proyecto;
    static Scanner sc =new Scanner(System.in);


    public static void gestor(){
        int opcion=0;
        while(opcion<1 || opcion>6) {
            System.out.println("Elija una de las siguientes opciones 1-6: ");
            System.out.println("1-Dar de alta a persona");
            System.out.println("2-Dar de alta tarea");
            System.out.println("3-Dar tarea como finalizada");
            System.out.println("4-Introducir/eliminar persona");
            System.out.println("5-Listar personas del proyecto");
            System.out.println("6-Listar tareas del proyecto");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
        }
        switch (opcion){
            case 1: darDeAltaPersona(); break;
            case 2: darDeAltaTarea(); break;
            case 3: finalizarTarea(); break;
            case 4: introducirEliminarPersonaDeTarea(); break;
            case 5: listarPersonas(); break;
            case 6: listarTareas(); break;
        }
        promptEnterKey();
    }
    public static Persona darDeAltaPersona(){
        Persona nuevaPersona= new Persona();
        System.out.println("Introduce el DNI de la persona:");
        nuevaPersona.setDni(leerString());
        System.out.println("Introduce el Nombre:");
        nuevaPersona.setNombre(leerString());
        System.out.println("Introduce el Correo:");
        nuevaPersona.setCorreo(leerString());
        System.out.println("#############\nClases.Persona Creada\n#############");
        proyecto.anyadirPersona(nuevaPersona);
        return nuevaPersona;
    }
    public static void darDeAltaTarea(){
        String identificador, resultadoInternoExterno, titulo, descripcion, responsable;
        int prioridad, numHoras;
        System.out.println("Introduce el titulo de la tarea:");
        titulo=leerString();
        System.out.println("Introduce una descripcion");
        descripcion=leerString();
        System.out.println("¿Quien es el responsable? (Poner DNI)");
        responsable=leerString();
        System.out.println("¿Cual es la prioridad de la tarea? \n(1 es muy prioritario y 5 es muy poco prioritario)");
        prioridad=leerInt();
        Tarea tarea=new Tarea(titulo,descripcion,responsable,prioridad);
        System.out.println("Introduzca un identificador de tarea: ");
        identificador=leerString();
        System.out.println("Introduzca el numero de horas estimadas: ");
        numHoras=leerInt();
        System.out.println("¿El resultado es externo o interno?");
        resultadoInternoExterno=leerString();
        System.out.println("¿Qué tipo de tarea quieres crear?");
        System.out.println("1 - Biblioteca\n2 - Documentación\n3 - Página Web\n4 - Programa");
        int tipoTarea=leerInt();
        String lenguaje;
        int numLineas,numModulos;
        switch (tipoTarea){
            case 1:
                System.out.println("¿Qué lenguaje quieres emplear?");
                lenguaje=leerString();
                System.out.println("¿Cuantas lineas habrá?");
                numLineas=leerInt();
                System.out.println("¿Cuántos módulos?");
                numModulos=leerInt();
                tarea.setResultado(new Biblioteca(identificador,numHoras,resultadoInternoExterno,
                        lenguaje,numLineas, numModulos));
                break;
            case 2:
                System.out.println("¿Qué formato vas a utilizar?");
                String formato=leerString();
                System.out.println("¿Cuántas páginas ocupa?");
                int numPaginas=leerInt();
                System.out.println("¿Cuanto espacio de almacenamiento ocupa?");
                double espacioEnDisco=leerDouble();
                tarea.setResultado(new Documentacion(identificador,numHoras,resultadoInternoExterno,
                        formato, numPaginas, espacioEnDisco));
                break;
            case 3:
                System.out.println("Es una Página Web de tipo estática o dinámica?");
                String estaticaDinamica=leerString();
                System.out.println("¿Qué lenguaje quieres emplear?");
                lenguaje=leerString();
                System.out.println("Introduce el tipo de backend: ");
                String backend=leerString();
                tarea.setResultado(new PaginaWeb(identificador,numHoras,resultadoInternoExterno,
                        estaticaDinamica, lenguaje, backend));
                break;
            case 4:
                System.out.println("¿Qué lenguaje quieres emplear?");
                lenguaje=leerString();
                System.out.println("¿Cuantas lineas ocupa?");
                numLineas=leerInt();
                System.out.println("¿Cuántos módulos?");
                numModulos=leerInt();
                tarea.setResultado(new Programa(identificador,numHoras,resultadoInternoExterno,
                        lenguaje, numLineas, numModulos));
                break;
        }
        System.out.println("Añade una etiqueta o \"exit\" para terminar:");
        String etiqueta=leerString();
        while(etiqueta.compareTo("exit")!=0){
            tarea.añadirEtiqueta(etiqueta);
            System.out.println("Etiqueta añadida, añade otra o \"exit\" para terminar:");
            etiqueta=leerString();
        }
        proyecto.anyadirTarea(tarea);
        System.out.println("\nResultado añadido.");



    }

    public static Persona encontrarPersona(String dni){
        Persona persona=proyecto.buscarPersona(dni);
        if(persona==null) {
            System.out.println("Esta persona no existe. Se va a crear:");
            persona = darDeAltaPersona();
        }
        return persona;

    }
    public static void promptEnterKey(){
        System.out.println("Pulsa \"ENTER\" para continuar...");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String mostrarPersonasAsignadas(Tarea tarea){
        String personas = "";
        ArrayList<Persona> listaPersonas=tarea.getPersonasAsignadas();
        if(listaPersonas.size()>0) {
            for (Persona persona : listaPersonas) {
                personas += "\n" + persona.getNombre();
            }
        } else personas="No hay personas asignadas";
        return personas;
    }
    public static String mostrarTarea(Tarea tarea){
        return "Título de la tarea: " + tarea.getTitulo()
                + "\nResponsable: " + tarea.getResponsable()
                + "\nPersonas asignadas: \n" + mostrarPersonasAsignadas(tarea)
                + "\n" + (tarea.isEsFinalizada()?"Clases.Tarea finalizada.":"Clases.Tarea sin finalizar")
                + "\n" + tarea.getResultado().mostrarResultadoEspecifico() +"\n";
    }
    public static void finalizarTarea(){
        System.out.println("Introduce el titulo de la tarea que quieres finalizar: ");
        String tituloTarea= leerString();
        boolean encontrada=false;
        for(Tarea tarea:proyecto.getListaTareas()){
            if(tarea.getTitulo().compareTo(tituloTarea)==0){
                encontrada=true;
                tarea.finalizarTarea();
                System.out.println("Clases.Tarea finalizada satisfactoriamente.");
                break;
            }
        }
        if(!encontrada) System.out.println("Clases.Tarea no encontrada");


    }
    public static void introducirEliminarPersonaDeTarea(){
        System.out.println("Indicame el DNI de la persona que quieres modificar: ");
        String dni=leerString();
        Persona persona=proyecto.buscarPersona(dni);
        System.out.println("1 - Introducir persona en tarea.\n2- Eliminar persona de tarea.");
        int opcion=leerInt();
        System.out.println("Escribe con precisión el titulo de la tarea.");
        String titulo=leerString();
        Tarea tarea= proyecto.buscarTarea(titulo);
        if(opcion==1){
            tarea.anyadirPersonasAsignadas(persona);
            persona.añadirTareaAPersona(tarea);
        } else {
            tarea.eliminarPersonasAsignadas(persona);
            persona.eliminarTareaDePersona(tarea);
        }
    }
    public static void listarPersonas(){
        for(Persona persona:proyecto.getListaPersonas()){
            System.out.println(persona.getNombre() + " " + persona.getCorreo());
        }
    }
    public static void listarTareas(){
        for(Tarea tarea:proyecto.getListaTareas()){
            System.out.println(mostrarTarea(tarea));
        }
    }
    public static String leerString(){
        return sc.next();
    }

    public static int leerInt(){
        return sc.nextInt();
    }

    public static Double leerDouble(){
        return sc.nextDouble();
    }

    public static void crearProyecto(){
        proyecto= new Proyecto();
        establecerNombreProyecto(proyecto);
    }
    public static void establecerNombreProyecto(Proyecto nuevoProyecto){
        System.out.println("Iniciando nuevo proyecto.\n\n¿Cómo desea llamarlo?");
        nombreProyecto=leerString();
        nuevoProyecto.setNombreProyecto(nombreProyecto);
        System.out.println(String.format("Nombre establecido, proyecto \"{0}\" creado.", nombreProyecto));
    }
    public static void pedirNombreTarea(){
        System.out.println("Introduce el nombre de la Clases.Tarea: ");

    }
    public static void pedirNombrePersona(){
        System.out.println("Introduce el nombre del responsable: ");
    }

    public static void main(String[] args) {
        crearProyecto();
        while(true) gestor();

    }
}
