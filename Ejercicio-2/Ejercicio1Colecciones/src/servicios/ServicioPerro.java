/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import atributos.AtributoPerro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author A278617
 */
public class ServicioPerro {
    
    private ArrayList<AtributoPerro> listadoDeRazas;
        public ServicioPerro(){
            this.listadoDeRazas=new ArrayList();
        }
    
    
    public void CargaRaza(){
        Scanner leer = new Scanner(System.in);
        System.out.println("ingrese la raza del perro");
        String raza=leer.next().toUpperCase();
        AtributoPerro P1 = new AtributoPerro(raza);
        listadoDeRazas.add(P1);
        System.out.println("quiere cargar otro perro? ingrese S o N");
        String opc = leer.next();
        if("S".equalsIgnoreCase(opc)){
            CargaRaza();
        }else{
            MostrarArray();
            menuRaza();
        }
        
    }
    
    public void MostrarArray(){
        if (listadoDeRazas.isEmpty()) {
            System.out.println("no hay razas cargadas");
            
        }else{
            
        
        for (int i = 0; i < listadoDeRazas.size(); i++) {
            AtributoPerro perro = listadoDeRazas.get(i);
            System.out.println(perro.getRaza());
            System.out.println("la raza fue borrada");
        }
        }
            menuRaza();
        }
    
    public void mostrarBorrarPerro(){
        Scanner leer = new Scanner(System.in);
        System.out.println("ingrese la raza a buscar");
        String raza = leer.next().toUpperCase();
        int contador = 0;
        Iterator<AtributoPerro> it = listadoDeRazas.iterator();
        while(it.hasNext()){
            AtributoPerro aux=it.next();
            if (aux.getRaza().equals(raza)) {
                contador=contador+1;
                it.remove();
            }
        }
        
        if (contador==0) {
            System.out.println("la raza no esta en la base");
            
        }

            System.out.println("Lista ordenada");
        Collections.sort(listadoDeRazas);
        
        MostrarArray();
        
        System.out.println("desea borrar otra raza? escriba s o n");
        String opc = leer.next();
        if("S".equalsIgnoreCase(opc)){
            mostrarBorrarPerro();
        }
        menuRaza();
    }
    
    public void mostrarPerro(){
        Scanner leer = new Scanner(System.in);
        System.out.println("ingrese la raza a buscar");
        String raza = leer.next().toUpperCase();
        int contador = 0;
        Iterator<AtributoPerro> it = listadoDeRazas.iterator();
        while(it.hasNext()){
            AtributoPerro aux=it.next();
            if (aux.getRaza().equals(raza)) {
                contador=contador+1;
            }
        }
        
        if (contador==0) {
            System.out.println("la raza no esta en la base");
            
        }else{
            System.out.println("la raza esta" +contador+ "veces");
            
        }
   
        System.out.println("desea buscar otra raza? escriba s o n");
        String opc = leer.next();
        if("S".equalsIgnoreCase(opc)){
            mostrarPerro();
        }
        menuRaza();
    }
        public void menuRaza(){
            Scanner leer=new Scanner(System.in);
            System.out.println("elija una de las sig opciones");
            System.out.println("1: Cargar una raza");
            System.out.println("2: Borrar una raza");
            System.out.println("3: Mostrar razas");
            System.out.println("4: Buscar razas");
            System.out.println("9: Salir");
            int opcion = leer.nextInt();
            switch(opcion){
                case 1:CargaRaza();
                break;
                case 2:mostrarBorrarPerro();
                break;
                case 3:MostrarArray();
                break;
                case 4:mostrarPerro();
                break;
                case 9:System.out.println("adiós");
                break;
                default: break;
            }
            
        }
    
    
    }

