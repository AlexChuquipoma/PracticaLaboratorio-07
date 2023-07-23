/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.cantante.compositor.interfaces.modelo;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Disco {
    private int codigo; 
    private String nombre; 
    private int anioDeLanzamiento; 
    
     // Constructor vacío
    public Disco() {
        
    }
    
    // Constructor que acepta el código, nombre y año de lanzamiento del disco
    
    public Disco(int codigo, String nombre, int anioDeLanzamiento) {
        this.codigo = codigo; 
        this.nombre = nombre; 
        this.anioDeLanzamiento = anioDeLanzamiento; 
    }
    // Método para obtener el código del disco
    public int getCodigo() {
        return codigo; 
    }
    // Método para establecer el código del disco
    
    public void setCodigo(int codigo) {
        this.codigo = codigo; 
    }
     // Método para obtener el nombre del disco
    
    public String getNombre() {
        return nombre; 
    }
    // Método para establecer el nombre del disco
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     // Método para obtener el año de lanzamiento del disco

    public int getAnioDeLanzamiento() {
        return anioDeLanzamiento; 
    }
    // Método para establecer el año de lanzamiento del disco
    
    public void setAnioDeLanzamiento(int anioDeLanzamiento) {
        this.anioDeLanzamiento = anioDeLanzamiento; 
    }
    
    
    // Método hashCode para generar un valor hash único para el objeto basado en su nombre
    
    
    @Override
    public int hashCode() {
        int hash = 7; 
        hash = 29 * hash + Objects.hashCode(this.nombre); 
        return hash; 
    }
    // Método equals para comparar si dos objetos Disco son iguales basados en su nombre
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { 
            return true;
        }
        if (obj == null) { 
            return false;
        }
        if (getClass() != obj.getClass()) { 
            return false;
        }
        final Disco other = (Disco) obj; 
        if (Objects.equals(this.nombre, other.nombre)){ 
            return false;
        }
        return true;
    }
    // Método toString para representar el objeto Disco como una cadena
    

    @Override
    public String toString() {
        return "\nDisco: " + "Codigo: " + codigo + "Nombre: " + nombre + "AnioDeLanzamiento: " + anioDeLanzamiento + '}'; 
    }
}

