
package persistencia;

import modelo.Publicacion;
import java.util.List;

public interface IPublicacionDao {
    
    void insertarPublicacion(Publicacion p);
    List<Publicacion> leerPublicaciones();
    Publicacion buscarPublicacion(Publicacion p);
    Publicacion eliminarPublicacion(Publicacion p);
    
}
