package utilidades;

import Excepciones.ExcepcionArchivo;
import java.util.List;
import modelo.Libro;

/**
 *
 * @author asus
 */
public interface libreria {
    
    void registrar(Libro h) throws ExcepcionArchivo;
    List<Libro> leer() throws ExcepcionArchivo;
    Libro buscar(Libro h) throws ExcepcionArchivo;
    Libro eliminar(Libro h)throws ExcepcionArchivo;
    
}
