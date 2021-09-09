package ar.com.gm.peliculas.servicio;

public interface CatalogoPeliculas {

    String NOMBRE_ARCHIVO = "peliculas.txt";

    void agregarPelicula(String nombrePelicula);

    void listarPeliculas();

    void buscarPeliculas(String buscar);

    void iniciarCatalogoPeliculas();

}
