/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import entidades.Pelicula;
import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class comparadores {

    public static Comparator<Pelicula> ordenarPorDuracionMenorMayor = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getDuracion().compareTo(p2.getDuracion());
        }
    };
    public static Comparator<Pelicula> ordenarPorDuracionMayorMenor = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            
           return p2.getDuracion().compareTo(p1.getDuracion());
        }
    };
    public static Comparator<Pelicula> ordenarPorTitulo = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getTitulo().compareTo(p2.getTitulo());
        }
    };
    public static Comparator<Pelicula> ordenarPorDirecto = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getDirector().compareTo(p2.getDirector());
        }
    };
}
