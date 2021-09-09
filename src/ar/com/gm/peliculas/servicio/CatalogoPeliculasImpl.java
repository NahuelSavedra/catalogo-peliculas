package ar.com.gm.peliculas.servicio;

import ar.com.gm.peliculas.datos.*;
import ar.com.gm.peliculas.domain.Pelicula;
import ar.com.gm.peliculas.excepciones.*;

import java.util.List;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_ARCHIVO);
            datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
        } catch (AccesoDatosEx e) {
            e.printStackTrace();
            System.out.println("Error de acceso de datos");
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            List<Pelicula> peliculas = this.datos.listar(NOMBRE_ARCHIVO);
            for (var pelicula: peliculas) {
                System.out.println("Pelicula: " + pelicula);
            }
        } catch (LecturaDatosEx e) {
            e.printStackTrace();
            System.out.println("Error de acceso de datos");
        }

    }

    @Override
    public void buscarPeliculas(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_ARCHIVO, buscar);
        } catch (LecturaDatosEx e) {
            e.printStackTrace();
            System.out.println("Error de acceso de datos");
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_ARCHIVO)) {
                datos.borrar(NOMBRE_ARCHIVO);
                datos.crear(NOMBRE_ARCHIVO);
            }else {
                datos.crear(NOMBRE_ARCHIVO);
            }
        } catch (AccesoDatosEx e) {
            e.printStackTrace();
            System.out.println("Error al iniciar catalogo");
        }
    }
}
