/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Producto;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ProductoServicio {

    HashMap<String, Producto> productos = new HashMap();

    public void cargarProductos() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine().toUpperCase();
        
        System.out.println("Ingrese el precio de venta del producto " + nombre);
        double precio = scanner.nextDouble();
        scanner.nextLine();
        
        String clave =nombre+(int)precio;
        
        Producto proNuevo = new Producto(nombre, precio);

        productos.put(clave, proNuevo);
        
        System.out.println("Quiere agrecar otro producto S/N");
        String opcion1 = scanner.next();
        if (opcion1.equalsIgnoreCase("S")) {
            cargarProductos();
        } 
    }

    public void mostrarProductos() {
        if(productos.isEmpty()){
            System.out.println("No hay productos cargados");
        }else{
        for (Map.Entry<String, Producto> entry : productos.entrySet()) {
            String key = entry.getKey();
            Producto producto = entry.getValue();
            System.out.println("ID: "+key+"NOMBRE: "+producto.getNombre()+"PRECIO: "+producto.getPrecio());
            }
        }

    }

    public void borrarProducto() {
        Scanner scanner = new Scanner(System.in);
        String resultado;
        System.out.println("Selecciones una de las siguientes opciones:");
        System.out.println("1-Buscar por nombre");
        System.out.println("2-Buscar por codigo de producto");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch(opcion){
            case 1:
                String nombre="";
                String clave="";
                double precioNuevo;
                System.out.println("Ingrese el nombre del producto a borrar");
                nombre= scanner.nextLine().toUpperCase();
                scanner.nextLine();
                boolean auxResultado=false;
                  for (Map.Entry<String,Producto> entry: productos.entrySet()) {
                    if(entry.getValue().getNombre().equalsIgnoreCase(nombre)){
                        clave=entry.getKey();
                        auxResultado=true;
                        break;
                    }
                }
                if(!auxResultado){
                    System.out.println("No se encontro el producto");
                }else{
                    productos.remove(clave);
                }
                break;
            case 2:
                nombre="";
                System.out.println("Ingrese la clave del producto a modificar");
                clave= scanner.nextLine().toUpperCase();
                auxResultado=false;
                for (Map.Entry<String,Producto> entry: productos.entrySet()) {
                    if(entry.getKey().equals(clave)){
                        auxResultado=true;
                    }
                }
                if(!auxResultado){
                    System.out.println("No se encontro el producto");
                }else{
                    productos.remove(clave);
                }
                break;
            default:
                break;
                
        }
        
        System.out.println("Quiere borrar otro producto S/N");
        String opcion1 = scanner.next();
        scanner.nextLine();
        if (opcion1.equalsIgnoreCase("S")) {
            borrarProducto();
        }

    }
    
    public void modificarProductoPrecio(){
        Scanner scanner = new Scanner(System.in);
        String resultado;
        System.out.println("Selecciones una de las siguientes opciones:");
        System.out.println("1-Buscar por nombre");
        System.out.println("2-Buscar por codigo de producto");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch(opcion){
            case 1:
                String nombre="";
                String clave="";
                double precioNuevo;
                System.out.println("Ingrese el nombre del producto a modificar");
                nombre= scanner.nextLine().toUpperCase();
                System.out.println("Ingrese el nuevo precio");
                precioNuevo = scanner.nextDouble();
                
                boolean auxResultado=false;
                  for (Map.Entry<String,Producto> entry: productos.entrySet()) {
                    if(entry.getValue().getNombre().equalsIgnoreCase(nombre)){
                        clave=entry.getKey();
                        auxResultado=true;
                    }
                }
                if(!auxResultado){
                    System.out.println("No se encontro el producto");
                }else{
                    Producto nuevoPorducto = new Producto(nombre,precioNuevo);
                    productos.replace(clave, nuevoPorducto);
                }
                break;
            case 2:
                scanner.nextLine();
                nombre="";
                clave="";
                precioNuevo=0;
                System.out.println("Ingrese la clave del producto a modificar");
                clave= scanner.nextLine();
                System.out.println("Ingrese el nuevo precio");
                precioNuevo = scanner.nextDouble();
                auxResultado=false;
                for (Map.Entry<String,Producto> entry: productos.entrySet()) {
                    if(entry.getKey().equalsIgnoreCase(clave)){
                        nombre=entry.getValue().getNombre();
                        auxResultado=true;
                    }
                }
                if(!auxResultado){
                    System.out.println("No se encontro el producto");
                }else{
                    Producto nuevoPorducto = new Producto(nombre,precioNuevo);
                    productos.put(clave,nuevoPorducto);
                }
                break;
            default:
                break;
                
        }
        
        System.out.println("Quiere modificar otro producto S/N");
        String opcion1 = scanner.next();
        if (opcion1.equalsIgnoreCase("S")) {
            modificarProductoPrecio();
        } 
    }
    
    public void modificarProductoNombre(){
        Scanner scanner = new Scanner(System.in);
        String resultado;
        double precio=0;
        System.out.println("Selecciones una de las siguientes opciones:");
        System.out.println("1-Buscar por nombre");
        System.out.println("2-Buscar por codigo de producto");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch(opcion){
            case 1:
                String nombre="";
                String nombreNuevo;
                String clave="";
                System.out.println("Ingrese el nombre del producto a modificar");
                nombre= scanner.nextLine().toUpperCase();
                System.out.println("Ingrese el nuevo nombre");
                nombreNuevo = scanner.nextLine();
                
                boolean auxResultado=false;
                  for (Map.Entry<String,Producto> entry: productos.entrySet()) {
                    if(entry.getValue().getNombre().equalsIgnoreCase(nombre)){
                        clave=entry.getKey();
                        precio=entry.getValue().getPrecio();
                        auxResultado=true;
                    }
                }
                if(!auxResultado){
                    System.out.println("No se encontro el producto");
                }else{
                    Producto nuevoPorducto = new Producto(nombreNuevo,precio);
                    productos.replace(clave, nuevoPorducto);
                }
                break;
            case 2:
                scanner.nextLine();
                nombre="";
                nombreNuevo="";
                clave="";
                precio=0;
                System.out.println("Ingrese la clave del producto a modificar");
                clave= scanner.nextLine();
                System.out.println("Ingrese el nuevo nombre");
                nombreNuevo = scanner.nextLine().toUpperCase();
                auxResultado=false;
                for (Map.Entry<String,Producto> entry: productos.entrySet()) {
                    if(entry.getKey().equalsIgnoreCase(clave)){
                        precio=entry.getValue().getPrecio();
                        auxResultado=true;
                    }
                }
                if(!auxResultado){
                    System.out.println("No se encontro el producto");
                }else{
                    Producto nuevoPorducto = new Producto(nombreNuevo,precio);
                    productos.put(clave,nuevoPorducto);
                }
                break;
            default:
                break;
                
        }
        
        System.out.println("Quiere modificar otro producto S/N");
        String opcion1 = scanner.next();
        if (opcion1.equalsIgnoreCase("S")) {
            modificarProductoNombre();
        } 
    }
    
public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        
        while (!salir) {
            
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Cargar un producto");
            System.out.println("2. Modificar el precio de un producto");
            System.out.println("3. Modificar el nombre de un producto");
            System.out.println("4. Eliminar un producto");
            System.out.println("5. Mostrar productos disponibles");
            System.out.println("6. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    cargarProductos();
                    break;
                case 2:
                     modificarProductoPrecio();
                    break;
                case 3:
                    modificarProductoNombre();
                    break;
                case 4:
                    borrarProducto();
                    break;
                case 5:
                    mostrarProductos();
                case 6:
                    salir=true;
                     System.out.println("¡Hasta luego!");
                     break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                    scanner.next();
                    break;
            }
        }
    }    
}
