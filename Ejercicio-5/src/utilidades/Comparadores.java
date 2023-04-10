/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import entidades.Pais;
import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class Comparadores {
    
    public static Comparator<Pais> ordenAscendente = new Comparator<Pais>() {
        @Override
        public int compare(Pais t1, Pais t2) {
            return t1.getNombre().compareTo(t2.getNombre());
        }
    };
    
     public static Comparator<Pais> ordenDescendente = new Comparator<Pais>() {
        @Override
        public int compare(Pais t1, Pais t2) {
            return t2.getNombre().compareTo(t1.getNombre());
        }
    };
}
