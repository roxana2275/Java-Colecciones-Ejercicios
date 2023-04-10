/*
 En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario 
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere 
crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones: 
22
• Mostrar en pantalla todas las películas.
• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en 
pantalla.
• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en 
pantalla.
• Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.
• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla
 */
package servicio;

import entidades.Pelicula;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import utilidades.comparadores;

/**
 *
 * @author Usuario
 */
public class servicioPelicula {

    private ArrayList<Pelicula> peliculas;

    public servicioPelicula() {
        peliculas = new ArrayList<>();
    }

    public void cargarPelicula() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el título de la película:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el director de la película:");
        String director = scanner.nextLine();
        System.out.println("Ingrese la cantidad de horas de la película:");
        int horas = scanner.nextInt();
        System.out.println("Ingrese la cantidad de minutos de la película:");
        int minutos = scanner.nextInt();

        LocalTime duracion = LocalTime.of(horas, minutos);

        Pelicula pelicula = new Pelicula(titulo, director, duracion);
        peliculas.add(pelicula);
        System.out.println("Quiere agregar otra película? (s/n");
        String opcion = scanner.next();
        if ("s".equalsIgnoreCase(opcion)) {
            cargarPelicula();
        }
        volverMenuPrincipal();
    }

    public void volverMenuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quiere volver al menu principal s/n");
        String eleccion = scanner.next().toLowerCase();
        if("s".equalsIgnoreCase(eleccion)){
            menu();
        }
    }
    public void noHayPeliculasCargadas(){
        if(peliculas.size()==0){
            System.out.println("No hay peliculas cargas");
            cargarPelicula();
        }
        
    }
    public void mostrarPelicula() {
        System.out.println("--------PELICULAS CARGADAS---------");
        noHayPeliculasCargadas();
        for (Pelicula catalogo : peliculas) {
            System.out.println(catalogo);
        }
        volverMenuPrincipal();

    }

    public void mostarPeliculaMasDeUnaHora() {
        System.out.println("---------PELICULAS DE MAS DE UNA HORA-------");
        noHayPeliculasCargadas();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getDuracion().compareTo(LocalTime.of(1, 0)) >= 0) {
                System.out.println(pelicula);
            }
        }
        volverMenuPrincipal();

    }

    public void mostarPorDuracionDeMenorAMayor() {
        System.out.println("---ORDENADAS POR HORA DE MENOR A MAYOR----");
        noHayPeliculasCargadas();
        Collections.sort(peliculas, comparadores.ordenarPorDuracionMenorMayor);
        peliculas.forEach(System.out::println);
volverMenuPrincipal();
    }

    public void mostarPorDuracionDeMayorAMenor() {
        System.out.println("--ORDENADAS POR HORA DE MAYOR A MENOR----");
        noHayPeliculasCargadas();
        Collections.sort(peliculas, comparadores.ordenarPorDuracionMayorMenor);
        peliculas.forEach(System.out::println);
        volverMenuPrincipal();
    }

    public void mostrarOrdenadasPorTitulo() {
        System.out.println("-----ORDENADAS POR TITULO-----");
        noHayPeliculasCargadas();
        Collections.sort(peliculas, comparadores.ordenarPorTitulo);
        peliculas.forEach(System.out::println);
        volverMenuPrincipal();
    }

    public void mostarOrdenadasPorDirector() {
        System.out.println("----ORDENADAS POR DIRECTOR----");
        noHayPeliculasCargadas();
        Collections.sort(peliculas, comparadores.ordenarPorDirecto);
        peliculas.forEach(System.out::println);
        volverMenuPrincipal();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elija una de las siguientes opciones:");
        System.out.println("1-Cargar Peliculas");
        System.out.println("2-Mostrar peliculas de mas de una hora:");
        System.out.println("3-Mostrar peliculas ordenadas por Hora de menor a mayor");
        System.out.println("4-Mostrar peliculas ordenadas por Hora de mayor a menor");
        System.out.println("5-Mostrar peliculas ordenadas por titulo:");
        System.out.println("6-Mostrar peliculas ordenadas por director:");
        System.out.println("7-Mostar peliculas cargadas");
        System.out.println("9-Salir");
        int opciones = scanner.nextInt();
        switch (opciones) {
            case 1:
                cargarPelicula();
                break;
            case 2:
                mostarPeliculaMasDeUnaHora();
                break;

            case 3:
                mostarPorDuracionDeMenorAMayor();
                break;
            case 4:
                mostarPorDuracionDeMayorAMenor();
                break;
            case 5:
                mostrarOrdenadasPorTitulo();
                break;
            case 6:
                mostarOrdenadasPorDirector();
                break;
            case 7:
                mostrarPelicula();
                break;
            case 9:
                break;
            default:
                break;
        }
    }

}
