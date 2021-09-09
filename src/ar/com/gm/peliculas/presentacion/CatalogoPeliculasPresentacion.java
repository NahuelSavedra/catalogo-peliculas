package ar.com.gm.peliculas.presentacion;

import ar.com.gm.peliculas.servicio.*;

import java.util.Scanner;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        Integer opcion = -1;
        Scanner scanner = new Scanner(System.in);
        CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("Elige una opcion: \n" +
                    "1. Iniciar catalogo peliculas\n" +
                    "2. Agregar pelicula\n" +
                    "3. Listar peliculas\n" +
                    "4. Buscar pelicula\n" +
                    "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula");
                    String nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("¿Que pelicula desea buscar? ");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPeliculas(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Accion desconocida");
            }
        }
    }
}
