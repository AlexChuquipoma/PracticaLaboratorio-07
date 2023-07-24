/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.cantante.compositor.interfaces.controlador;

import ec.edu.ups.practica.cantante.compositor.interfaces.dao.CantanteDao;
import ec.edu.ups.practica.cantante.compositor.interfaces.idao.ICompositorDao;
import ec.edu.ups.practica.cantante.compositor.interfaces.modelo.Cancion;
import ec.edu.ups.practica.cantante.compositor.interfaces.modelo.Cantante;
import ec.edu.ups.practica.cantante.compositor.interfaces.modelo.Compositor;
import java.util.List;

/**
 *
 * @author venot
 */
public class ControladorCompositor {
    private ICompositorDao compositorDao;// Objeto para interactuar con la capa de datos
    private Compositor compositor;
    private Cantante cantante;
    private CantanteDao cantantedao;

    // Constructor que acepta un objeto ICompositorDao para interactuar con la capa de datos
    
    public ControladorCompositor(ICompositorDao compositorDao) {
        this.compositorDao = compositorDao;
    }
    // Método para crear un nuevo compositor llamando al método "create" del DAO
    
    public void crearCompositor(Compositor compositor){
        compositorDao.create(compositor);
    }
     // Método para obtener una lista de todos los compositores llamando al método "findAll" del DAO
  
    public List<Compositor> verCompositores(){
        return compositorDao.findAll();
    }
     // Método para actualizar un compositor llamando al método "update" del DAO
    
    public void actualizarCompositor(Compositor compositor){
            compositorDao.update(compositor);
    }
    
    // Método para eliminar un compositor llamando al método "delete" del DAO
    public void elimininarCompo(Compositor compositor){
        compositorDao.delete(compositor);
        
    }
    // Método para buscar un compositor por su código llamando al método "read" del DAO

    public Compositor buscarCompositor(int codigo){
        return compositorDao.read(codigo);
    }
    // Método para buscar un compositor por el título de una canción llamando al método "buscarPorTituloDeCancion" del DAO
    
    public Compositor buscarPorTituloCancion(String nombre){
        return compositorDao.buscarPorTituloDeCancion(nombre);
    }
     // Método para agregar un cantante como cliente del compositor
    
    public void agregarClienteCan(Compositor compositor, Cantante cantante){
        compositor.agregarClientE(cantante);
    }
    // Método para actualizar la información de una canción en un compositor y actualizar la información en el DAO
    
    public void actualizarCancion(Compositor compositor,Cancion cancion){
        compositor.actualizarCancion(cancion);
    }
    // Método para agregar una canción a un compositor y actualizar la información en el DAO
    
    public void agregarCancion(Cancion cancion,Compositor compositor){
        compositor.agregarCancion(cancion);
    }
    // Método para buscar una canción en un compositor por su código
    
    public Cancion buscarCancion(Compositor compositor,int codigo){
        return compositor.buscarCancione(codigo);
    }
    // Método para eliminar una canción de un compositor y actualizar la información en el DAO
    
    public void eliminarCancion(Compositor compositor, int codigo){
        compositor.eliminarCancion(codigo);
    }
}
