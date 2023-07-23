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
public class Cancion {
    private int codigo; // Código numérico único de la canción
    private String titulo; // Título de la canción
    private String letra; // Letra de la canción
    private double tiempoEnMinutos; // Duración de la canción en minutos
    
    
  // Constructor vacío  
    public Cancion() { 
    }
    
  // Constructor con parámetros para inicializar todos los atributos 
    public Cancion(int codigo, String titulo, String letra, double tiempoEnMinutos) { 
        this.codigo = codigo; 
        this.titulo = titulo; 
        this.letra = letra; 
        this.tiempoEnMinutos = tiempoEnMinutos; 
    }
    
  // Métodos "get" y "set" para cada atributo
    
    public int getCodigo() { 
        return codigo;
    }

    public void setCodigo(int codigo) { 
        this.codigo = codigo;
    }

    public String getTitulo() { 
        return titulo;
    }

    public void setTitulo(String titulo) { 
        this.titulo = titulo;
    }

    public String getLetra() { 
        return letra;
    }

    public void setLetra(String letra) { 
        this.letra = letra;
    }

    public double getTiempoEnMinutos() {
        return tiempoEnMinutos;
    }

    public void setTiempoEnMinutos(double tiempoEnMinutos) { 
        this.tiempoEnMinutos = tiempoEnMinutos;
    }

    @Override
    public int hashCode() { 
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.titulo);
        return hash;
    }
    
// Método para calcular el código hash del objeto basado en el título
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
        final Cancion other = (Cancion) obj;
        return Objects.equals(this.titulo, other.titulo);
    }
 // Método para comparar si dos objetos Cancion son iguales basado en el título
    @Override
    public String toString() {
        return "\nCancion: " + "\nCodigo: " + codigo + "\nTitulo=" + titulo + "\nLetra=" + letra + "\nTiempoEnMinutos=" + tiempoEnMinutos + '}';
    }  
}
