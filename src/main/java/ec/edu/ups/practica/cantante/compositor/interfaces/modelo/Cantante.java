/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.cantante.compositor.interfaces.modelo;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class Cantante extends Persona { 

    private String nombreArtistico; 
    private String generoMusical; 
    private int numeroDeSencillos; 
    private int numeroDeConciertos; 
    private int numeroDeGiras;
    private List<Disco> discografia; 

    // Constructor vacío
    public Cantante() { 
        discografia = new ArrayList(); 
    }
    
    // Constructor que acepta el nombre artístico del cantante
    public Cantante(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    // Constructor que invoca al constructor de la clase Persona para inicializar los atributos heredados

    public Cantante(int codigo, String nombre, String apellido, int edad, String nacionalidad) {
        super(codigo, nombre, apellido, edad, nacionalidad);
    }

    // Constructor que invoca al constructor de la clase Persona para inicializar los atributos heredados
    // y también inicializa los atributos propios del cantante.
    
    public Cantante(String nombreArtistico, String generoMusical, int numeroDeSencillos, int numeroDeConciertos, int numeroDeGiras,  int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) { 
        super(codigo, nombre, apellido, edad, nacionalidad, salario); 
        this.nombreArtistico = nombreArtistico; 
        this.generoMusical = generoMusical; 
        this.numeroDeSencillos = numeroDeSencillos; 
        this.numeroDeConciertos = numeroDeConciertos; 
        this.numeroDeGiras = numeroDeGiras; 
        discografia = new ArrayList();
    }
    
    // Método para calcular el salario del cantante según ciertas condiciones
    @Override
    public double calcularSalario() { 
        double salarioFinal = getSalario();

        if (numeroDeSencillos > 10 && numeroDeGiras > 3) { 
            int comision = 1000; 
            salarioFinal += comision; 
        }
        if (numeroDeSencillos >= 1 && numeroDeSencillos <= 10) { 
            double f = salarioFinal * 0.05; 
            salarioFinal += f; 
        }
        if (numeroDeGiras >= 1 && numeroDeGiras <= 3) { 
            double g = salarioFinal * 0.03; 
            salarioFinal += g; 
        }
        if (discografia.size() >= 5) {
            int bono = 2000; 
            salarioFinal += bono; 
        }
        return salarioFinal; 
    }

    // Método para agregar un objeto Disco a la lista discografia
    public void agregarDisco(Disco discografi){
        discografia.add(discografi); 
    }
    // Método para buscar un disco en la lista discografia según su código
    
    public Disco buscarDisco(int codigo){
        for (Disco disco : discografia) {
            if (disco.getCodigo()== codigo) {
                return disco;
            }
        }
        return null;
    }
    
    // Método para obtener la lista completa de discos del cantante
    
    public List<Disco> listarDiscos(){
        return discografia;
    }
    // Método para actualizar un disco en la lista discografia según su código
    
    public void actualizarDisco(Disco discoActualizado) {
        for (Disco disco : discografia) {
            if (disco.getCodigo() == discoActualizado.getCodigo()) {
                disco.setNombre(discoActualizado.getNombre());
                disco.setAnioDeLanzamiento(discoActualizado.getAnioDeLanzamiento());
                System.out.println("Disco actualizado correctamente.");
                return;
            }
        }
        System.out.println("El disco no se encontró en la lista.");
    }
   // Método para eliminar un disco de la lista discografia según su código
    
    public void eliminarDisco(int codigoDisco) {
        Disco discoAEliminar = null;
        for (Disco disco : discografia) {
            if (disco.getCodigo() == codigoDisco) {
                discoAEliminar = disco;
                break;
            }
        }

        if (discoAEliminar != null) {
            discografia.remove(discoAEliminar);
            System.out.println("Disco eliminado correctamente.");
        } else {
            System.out.println("El disco con el código especificado no se encontró en la discografía.");
        }
    }
    // Métodos "get" y "set" para cada atributo
    
    public String getNombreArtistico() {
        return nombreArtistico; 
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico; 
    }

    public String getGeneroMusical() {
        return generoMusical; 
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical; 
    }

    public int getNumeroDeSencillos() {
        return numeroDeSencillos; 
    }

    public void setNumeroDeSencillos(int numeroDeSencillos) {
        this.numeroDeSencillos = numeroDeSencillos; 
    }

    public int getNumeroDeConciertos() {
        return numeroDeConciertos; 
    }

    public void setNumeroDeConciertos(int numeroDeConciertos) {
        this.numeroDeConciertos = numeroDeConciertos; 
    }

    public int getNumeroDeGiras() {
        return numeroDeGiras; 
    }

    public void setNumeroDeGiras(int numeroDeGiras) {
        this.numeroDeGiras = numeroDeGiras; 
    }

    public List<Disco> getDiscos() {
        return discografia; 
    }

    public void setDiscos(List<Disco> discos) {
        this.discografia = discos; 
    }

    // Método toString() para representar el objeto Cantante como una cadena
    
    @Override
    public String toString() {
        return "Cantante"+ super.toString()  + "\nNombreArtistico:" + nombreArtistico + "\nGeneroMusical=" + generoMusical + "\nNumeroDeSencillos=" + numeroDeSencillos + "\nNumeroDeConciertos=" + numeroDeConciertos + "\nNumeroDeGiras=" + numeroDeGiras + "\nLista de Discos: " + discografia ;
    }  

    
}