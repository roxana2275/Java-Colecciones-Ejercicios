/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ServiciosRaza {
    
    Scanner leer = new Scanner (System.in);
    /*
    private 
            */
            List<String> razas= new ArrayList<>();
    /*
    public ServiciosRaza(){
        this.razas = new ArrayList<>();
    }
*/


    public void crearRaza(){
        String respuesta = "";
        
        do{
            System.out.println("Ingrese una raza de perro");
            String m = leer.next().toUpperCase();
            razas.add(m);
            System.out.println("Quiere ingresar otra raza S/N");
            respuesta=leer.next().toUpperCase();
            
        }while(!"N".equals(respuesta));
        

    }
    
    public void mostrarRazas(){
        System.out.println("Las razas cargadas son: ");
        for (String aux : razas) {
            System.out.println(aux);
        }
        System.out.println("El total de razas cargadas es "+razas.size());
    }
    
    public void buscarRaza(){
        String respuesta = "";
        String buscarRaza;
        int encontradas=0;
        do{

            System.out.println("Ingrese la raza a buscar: ");
            buscarRaza=leer.next().toUpperCase();
            System.out.println("La raza a buscar es: "+buscarRaza);
            for(String aux:razas){
                if(aux.equals(buscarRaza)){
                    encontradas=encontradas+1;
                }                
            }
            
            if(encontradas>0){
                System.out.println("La raza se encuentra en la lista");
            }else{
                System.out.println("La raza no se encuentra en la lista");
            }
            encontradas=0;
            System.out.println("Quiere buscar otra raza S/N");
            respuesta=leer.next().toUpperCase();   
            
        }while(!"N".equals(respuesta));
    }
    
    public void borrarRaza(){
        String buscarRaza;
        String respuesta = "";
        int encontradas=0;
        do{
            System.out.println("Ingrese la raza a borrar: ");
            buscarRaza=leer.next().toUpperCase();
            System.out.println("La raza a borrar es "+buscarRaza);
            Iterator<String> it = razas.iterator();
            while(it.hasNext()){
                String aux=it.next();
                if(buscarRaza.equals(aux)){
                    encontradas=encontradas+1;
                    System.out.println("Se encontro la raza, se procede a borrarla");
                    it.remove();
                }
            }
            if(encontradas==0){
                    System.out.println("La raza no existe");
                }
            encontradas=0;
            System.out.println("Quiere buscar otra raza S/N");
            respuesta=leer.next().toUpperCase();
            
        }while(!"N".equals(respuesta));
        Collections.sort(razas);
        System.out.println("La lista ordenada es: "+ razas);
    }
    
    public void menuRazas(){
        int opcion;
        do {
            System.out.println("Ingrese una de las siguientes opciones");
            System.out.println("1-Ingresar una raza");
            System.out.println("2-Buscar posicion de una raza");
            System.out.println("3-Borrar una raza");
            System.out.println("4-Mostrar listado de razas");
            System.out.println("9-Salir");
            opcion = leer.nextInt();
            switch(opcion){
                case 1:
                    crearRaza();
                    mostrarRazas();
                    break;
                case 2 :
                    buscarRaza();
                    break;
                case 3:
                    borrarRaza();
                    break;
                case 4:
                    mostrarRazas();
                    break;
                default:
                    System.out.println("La opcion elegida no es correcta");
                    break;
        }
        } while (opcion!=9);
        mostrarRazas();
    }
}
