X/*
 En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide 
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le 
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bucle tendremos el siguiente método en el servicio de Alumno: 
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota 
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro 
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este 
promedio final, devuelto por el método y mostrado en el main
 */
package servicios;

import entidades.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ServiciosAlumno {

    private ArrayList<Alumno> listaAlumnos;

    public ServiciosAlumno() {
        this.listaAlumnos = new ArrayList<>();
    }

    public void crearAlumno() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la cantidad de notas a ingresar para el alumno " + nombre);
        int cantidad = scanner.nextInt();
        ArrayList<Integer> notas = new ArrayList<>();
        for (int i = 0; i <= (cantidad - 1); i++) {
            System.out.print("Ingrese la nota " + (i + 1) + " del alumno: " + nombre);
            int nota = scanner.nextInt();
            notas.add(nota);
        }

        Alumno alumno = new Alumno(nombre, notas);
        listaAlumnos.add(alumno);

        System.out.print("¿Desea crear otro alumno? (s/n): ");
        String opcion = scanner.next().toLowerCase();
        if (opcion.equalsIgnoreCase("s")) {
            crearAlumno();
        }
    }

    public double notaFinal(String nombreAlumno) {
        
        for (Alumno alumno : listaAlumnos) {
        if (alumno.getNombre().equalsIgnoreCase(nombreAlumno)) {
            ArrayList<Integer> notas = alumno.getNotas();
            int contador = 0;
            for (int i = 0; i < notas.size(); i++) {
                contador = contador + notas.get(i);
            }
            double promedio = contador / notas.size();
            return promedio;
        }
    }
        return -1;// si no se encuentra el alumno, se devuelve -1
    }  

    public void consultarAlumno() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del alumno para calcular su nota final: ");
        String nombreAlumno = scanner.nextLine();

        double notaFinal = notaFinal(nombreAlumno);
        if (notaFinal == -1) {
            System.out.println("No se encontró un alumno con ese nombre.");
        } else {
            System.out.println("La nota final de " + nombreAlumno + " es " + notaFinal);
        }
    }

    public void menuAlumnos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione: ");
        System.out.println("1-Ingresar un alumno");
        System.out.println("2-Consultra nota final de un alumno");
        System.out.println("9-Salir");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                crearAlumno();
                break;
            case 2:
                consultarAlumno();
                break;
            case 9:
                break;
            default:
                break;
        }
        if(menu!=9){
            System.out.print("¿Desea volver al menu principal? (s/n): ");
            String eleccion = scanner.next().toLowerCase();
            if (eleccion.equalsIgnoreCase("s")) {
                menuAlumnos();
        }
        }
        

    }
}
