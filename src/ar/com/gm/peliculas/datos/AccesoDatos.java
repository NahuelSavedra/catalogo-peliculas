package ar.com.gm.peliculas.datos;
import ar.com.gm.peliculas.domain.Pelicula;
import ar.com.gm.peliculas.excepciones.*;
import java.util.List;

    //Define el comportamiento
public interface AccesoDatos {
    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    void crear(String nombreArchivo) throws AccesoDatosEx;

    void borrar(String nombreArchivo) throws AccesoDatosEx;
}
