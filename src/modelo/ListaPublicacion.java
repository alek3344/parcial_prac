/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import persistencia.ArrayListPublicacion;
import persistencia.IPublicacionDao;
import java.util.List;

/**
 *
 * @author JAIRO
 */
public class ListaPublicacion implements IPublicacionDao {
    
    private IPublicacionDao registroPublicaciones;

    public ListaPublicacion() {
        this.registroPublicaciones = new ArrayListPublicacion();
    }
    
    
    @Override
    public void insertarPublicacion(Publicacion p) {
        
        this.registroPublicaciones.insertarPublicacion(p);
        
    }

    @Override
    public List<Publicacion> leerPublicaciones() {
        
        return this.registroPublicaciones.leerPublicaciones();
        
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) {
        
        return this.registroPublicaciones.buscarPublicacion(p);
        
    }

    @Override
    public Publicacion eliminarPublicacion(Publicacion p) {
        
        return this.registroPublicaciones.eliminarPublicacion(p);
        
    }
    
}
