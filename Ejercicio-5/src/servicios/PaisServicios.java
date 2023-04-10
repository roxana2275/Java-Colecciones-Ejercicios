/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Pais;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import utilidades.Comparadores;


/**
 *
 * @author Usuario
 */
public class PaisServicios {

    private Set<Pais> paises;

    public PaisServicios() {
        paises = new HashSet();
    }

    public void cargarPaises() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un pais");
        String aux = scanner.nextLine();
        Pais p1 = new Pais();
        p1.setNombre(aux);
        paises.add(p1);
        System.out.println("Quiere ingresar otro pais? S/N");
        String opciones = scanner.next();
        if ("s".equalsIgnoreCase(opciones)) {
            cargarPaises();
        } else {
            mostrarPaises();
        }

    }

    public void mostrarPaises() {
        paises.forEach(System.out::println);
    }

    public void ordenarListaDescendente() {
        ArrayList<Pais> listaPaises = new ArrayList<>(paises);
        Collections.sort(listaPaises, Comparadores.ordenDescendente);
        listaPaises.forEach(System.out::println);
    }

    public void ordenarListaAscendente() {
        ArrayList<Pais> listaPaises = new ArrayList<>(paises);
      Collections.sort(listaPaises, Comparadores.ordenAscendente);
        listaPaises.forEach(System.out::println);
    }

    public void borrarPais() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el pais que quiere borrar: ");
        String paisBorrar = scanner.nextLine().trim();
        Iterator<Pais> it = paises.iterator();
        while (it.hasNext()) {
            Pais paisActual = it.next();
            if (paisActual.getNombre().equals(paisBorrar)) {
                it.remove();
            }
        }
        mostrarPaises();
    }

}
