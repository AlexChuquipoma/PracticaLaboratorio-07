/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.cantante.compositor.interfaces.modelo;


/**
 *
 * @author Usuario
 */
public abstract class Persona {
    private int codigo;  // Atributo para almacenar el código de la persona         
    private String nombre;  // Atributo para almacenar el nombre de la persona      
    private String apellido; // Atributo para almacenar el apellido de la persona    
    private int edad; // Atributo para almacenar la edad de la persona          
    private String nacionalidad; // Atributo para almacenar la nacionalidad de la persona 
    private double salario;   // Atributo para almacenar el salario de la persona    

      // Constructor vacío
    public Persona() {
    }
    // Constructor que acepta el código, nombre, apellido, edad y nacionalidad de la persona
    
    
    public Persona(int codigo, String nombre, String apellido, int edad, String nacionalidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }
    // Constructor que acepta el código, nombre, apellido, edad, nacionalidad y salario de la persona
    
    public Persona(int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.salario = salario;
    }
    // Método para obtener el código de la persona
   
    public int getCodigo() {
        return codigo;
    }
     // Método para establecer el código de la persona
   
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
      // Método para obtener el nombre de la persona
   
    public String getNombre() {
        return nombre;
    }
    // Método para establecer el nombre de la persona
  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   // Método para obtener el apellido de la persona
    
    public String getApellido() {
        return apellido;
    }
   // Método para establecer el apellido de la persona
  
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
  // Método para obtener la edad de la persona
   
    public int getEdad() {
        return edad;
    }
   // Método para establecer la edad de la persona
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
   // Método para obtener la nacionalidad de la persona
   
    public String getNacionalidad() {
        return nacionalidad;
    }
// Método para establecer la nacionalidad de la persona
   
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
  // Método para obtener el salario de la persona
   
    public double getSalario() {
        return salario;
    }
 // Método para establecer el salario de la persona

    public void setSalario(double salario) {
        this.salario = salario;
    }
// Método abstracto que debe ser implementado por las subclases para calcular el salario de la persona
 
    public abstract double calcularSalario();
    // Método hashCode para generar un valor hash único para el objeto basado en su código
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.codigo;
        return hash;
    }
    // Método equals para comparar si dos objetos Persona son iguales basados en su código
    
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
        final Persona other = (Persona) obj;
        return this.codigo == other.codigo;
    }
   // Método toString para representar el objeto Persona como una cadena
    
 
    @Override
    public String toString() {
        return "\nCodigo : " + codigo + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nEdad: " + edad + "\nNacionalidad: " + nacionalidad + "\nSalario :" + calcularSalario();
    }
    
}

