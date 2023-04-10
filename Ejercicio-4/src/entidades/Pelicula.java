/*
 Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto, 
tendremos una clase Pelicula con el título, director y duración de la película (en horas). 
 */
package entidades;

import java.time.LocalTime;



/**
 *
 * @author Usuario
 */
public class Pelicula {
    private String titulo;
    private String director;
    private LocalTime duracion;

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, LocalTime duracion) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Titulo=" + titulo + ", director=" + director + ", duracion= " + duracion;
    }
    
    
}
