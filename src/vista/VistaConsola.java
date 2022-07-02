
package vista;

import static java.time.Clock.system;
import modelo.ListaPublicacion;
import modelo.AudioLibro;
import modelo.Libro;
import modelo.Publicacion;
import utilidades.Consola;
import java.util.InputMismatchException;
import java.util.List;
import persistencia.ArchivoText;
import persistencia.IPublicacionDao;

public class VistaConsola {
    
    private String opciones[]={"1.Insertar Publicacion", "2.Leer Publicaciones", "3.Buscar Publicacion", "4.Eliminar Publicacion", "5. Salir"};
    private int seleccion;
    private ListaPublicacion modelo;
    private boolean salir=true;
    
    IPublicacionDao archivo = (IPublicacionDao) new ArchivoText();
    
    public VistaConsola() {
        if (salir == true)
        {
            this.modelo = new ListaPublicacion();
        }
    }
        
    
    public void verOpcionesMenu(){
        if (salir == true)
        {
            System.out.println("\n[   MENU DE OPCIONES  ]\n");
            
            for(String item: this.opciones){
                System.out.println(item);
            }
            
            try
            {
                this.seleccion=Consola.getInteger("\nSeleccione una opcion: ");
                
                salir = true;
            }
            catch(InputMismatchException e)
            {
                System.out.println(" \n-- debe ingresar un entero --\n");
                System.exit(0);
                salir = false;
            }
        }
    }
    
    
    public void evaluarSeleccion(){
        
        if  (salir == true)
        {
            if(this.seleccion<5){
            System.out.println(this.opciones[this.seleccion-1].toUpperCase());
            }
        
            switch(this.seleccion){
                case 1: this.registrarPublicacion();
                        break;
                case 2: this.leerPublicaciones();
                        break;
                case 3: this.buscarPublicacion();
                        break;
                case 4: this.eliminarPublicacion();
                        break;
                case 5: System.out.println("** Aplicacion finalizada ** ");
                        break;
                default: System.out.println("La opcion no es valida, intente nuevamente");
            }
        }
        
    }
    
    public void ejecutarMenu(){
        if (salir == true)
        {
            do{
                this.verOpcionesMenu();
                this.evaluarSeleccion();

            }while(this.seleccion!=5);
        }
    }
    
    public void run(){
        if(salir == true)
        {
            this.ejecutarMenu();
        }
    }
    
    public void leerPublicaciones(){
        
        if(salir == true)
        {
            System.out.println("Publicaciones registradas: ");
            System.out.printf("%-10s %-10s %-30s %-30s %-10s %-10s %-10s %-10s %-10s%n", "TIPO", "ISBN", "TITULO", "AUTOR", "NO PAG", "EDICION", "PESO", "DURACION", "FORMATO");
            System.out.println("-------------------------------------");
            List<Publicacion>  lista=this.modelo.leerPublicaciones();
            for(Publicacion p: lista){
                System.out.println(p.getStringFormat());
            }
            System.out.println("-------------------------------------");
            System.out.printf("Total %d publicaciones registradas%n", lista.size());
        }
        
    }
    
    public void registrarPublicacion(){
        
        Publicacion nuevaPublicacion = this.leerNuevaPublicacion();
        /*this.modelo.insertarPublicacion(nuevaPublicacion);
        if(salir == true)
        {
            System.out.println("\n!! Nueva publicacion registrada con exito ¡¡");
        }else
        {
            System.out.println(" -- registro interrumpido --");
        }*/
        if (salir == true)
        {
            archivo.insertarPublicacion(nuevaPublicacion);
            if(salir == true)
            {
                System.out.println("\n!! Nueva publicacion registrada con exito ¡¡");
            }else
            {
                System.out.println(" -- registro interrumpido --");
            }
            System.out.println("Caso 2: Lectura de archivo\n");
            List<Publicacion> lista = archivo.leerPublicaciones();
            for (Publicacion c : lista) {
                System.out.println(c);
            }
        }
        
    }
    
    public Publicacion leerNuevaPublicacion(){
        Publicacion publicacion = null;
        if(salir == true)
        {
            try
            {
                String isbn = Consola.getString("Isbn: ", "%-15s");
                String titulo = Consola.getString("Titulo: ", "%-15s");
                String autor = Consola.getString("Autor: ", "%-15s");
                int anio = Consola.getInteger("Año pub: ", "%-15s");
                double costo = Consola.getDouble("Costo: $ ", "%-15s");
                int tipo;
                do{
                    tipo = Consola.getInteger("Tipo? [1->Libro] [2->Audio Libro]: ", "%-15s");
                }while(tipo<1 || tipo>2);

                if(tipo==1){
                    int nPag = Consola.getInteger("No de paginas: ", "%-15s");
                    int edicion = Consola.getInteger("No edicion: ", "%-15s");

                    publicacion = new Libro(nPag, edicion, isbn, titulo, autor, anio, costo);
                }
                else{
                    String formato = Consola.getString("Formato: ", "%-15s");
                    double duracion = Consola.getDouble("Duracion (seg): ", "%-15s"); 
                    double peso = Consola.getDouble("Peso (Mb): ", "%-15s"); 
                    //publicacion = new AudioLibro(duracion, peso, formato, isbn, titulo, autor, anio, costo);
                }
                
                
                salir = true;
            }
            catch(InputMismatchException e)
            {
                System.out.println("-- debe ser un dato numerico --");
                System.exit(0);
                salir = false;
            }
        }
        return publicacion;
    }
    
    public void buscarPublicacion(){
        String isbn = null;
        if (salir == true)
        {
            try
            {
                isbn = Consola.getString("Isbn a buscar: ", "%-15s");

                salir = true;
            }catch(InputMismatchException e)
            {
                System.out.println(" -- debe ser un dato numerico --");
                System.exit(0);
                salir = false;
            }
            Publicacion pBusqueda = new Libro(isbn);
            Publicacion pResultado = this.modelo.buscarPublicacion(pBusqueda);
            if(pResultado!=null){
                System.out.println("\n!! Publicacion encontrada ¡¡");
                System.out.println(pResultado);
            }
            else{
                System.out.println("\n!! La Publicacion no se encuentra registrada ¡¡");
            }
        }
    }
    
    public void eliminarPublicacion(){
        String isbn = null;
        try
        {
            isbn = Consola.getString("Isbn a eliminar: ", "%-15s");
        }catch (InputMismatchException e)
        {       
            System.out.println(" -- debe ser un dato numerico --");
            System.exit(0);
            salir = false;
        }
        Publicacion pBusqueda = new Libro(isbn);
        
        Publicacion pEliminada = this.modelo.eliminarPublicacion(pBusqueda);
        if(pEliminada!=null){
            System.out.println("\n!! Publicacion eliminada ¡¡");
            System.out.println(pEliminada);
        }
        else{
            System.out.println("\n!! La Publicacion no se encuentra registrada ¡¡");
        }
        
    }
    
    
    
    
}
 