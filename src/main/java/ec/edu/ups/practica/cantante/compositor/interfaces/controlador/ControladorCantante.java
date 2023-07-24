/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.cantante.compositor.interfaces.controlador;

import ec.edu.ups.practica.cantante.compositor.interfaces.idao.ICantanteDao;
import ec.edu.ups.practica.cantante.compositor.interfaces.modelo.Cantante;
import ec.edu.ups.practica.cantante.compositor.interfaces.modelo.Disco;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ControladorCantante {

    private Cantante cantante;
    private Disco disco;
    private ICantanteDao cantanteDao;

    // Constructor que acepta un objeto ICantanteDao para interactuar con la capa de datos
    public ControladorCantante(ICantanteDao cantanteDao) {
        this.cantanteDao = cantanteDao;

    }

    // Método para registrar un nuevo cantante llamando al método "create" del DAO
    public void registrar(Cantante cantante) {
        cantanteDao.create(cantante);

    }
    // Método para actualizar un cantante llamando al método "update" del DAO

    public void actualizar(Cantante cantante) {

        cantanteDao.update(cantante);

    }
    // Método para eliminar un cantante llamando al método "delete" del DAO

    public void eliminar(Cantante cantante) {
        cantanteDao.delete(cantante);
    }

    // Método para buscar un cantante por su ID llamando al método "read" del DAO
    public Cantante buscarCantante(int id) {
        return cantanteDao.read(id);
    }
    // Método para obtener una lista de todos los cantantes llamando al método "findAll" del DAO

    public List<Cantante> verCantantes() {
        return cantanteDao.findAll();

    }
    // Método para buscar un cantante por el nombre de un disco llamando al método "buscarPorNombreDeDisco" del DAO

    public Cantante buscarporDisco(String nombre) {
        return cantanteDao.buscarPorNombreDeDisco(nombre);
    }
    // Método para eliminar un disco de un cantante y actualizar la información en el DAO

    public void eliminarDisco(Cantante cantante, int codigo) {
        List<Disco> listaDiscos = cantante.getDiscos();
        for (Disco listaDisco : listaDiscos) {
            if (listaDisco.getCodigo() == codigo) {
                cantante.eliminarDisco(codigo);
                cantanteDao.update(cantante);
            }
        }
    }
    // Método para actualizar la información de un disco de un cantante y actualizar la información en el DAO

    public void actualizarDisco(Cantante cantante, Disco disco) {
        cantante.actualizarDisco(disco);
        cantanteDao.update(cantante);
    }

}
