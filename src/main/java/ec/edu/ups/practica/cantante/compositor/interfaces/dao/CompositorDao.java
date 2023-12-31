/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.cantante.compositor.interfaces.dao;

import ec.edu.ups.practica.cantante.compositor.interfaces.idao.ICompositorDao;
import ec.edu.ups.practica.cantante.compositor.interfaces.modelo.Cancion;
import ec.edu.ups.practica.cantante.compositor.interfaces.modelo.Cantante;
import ec.edu.ups.practica.cantante.compositor.interfaces.modelo.Compositor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */

public class CompositorDao implements ICompositorDao{
    
    private String ruta;
    private RandomAccessFile archivoEscritura;
    
   private RandomAccessFile archivoLectura;
    //private RandomAccessFile archivito;
    //private List<Compositor> listaCompositor;

    public CompositorDao() {
        this.ruta = "src\\main\\resources\\rutas\\compositor.djj";
    }
    
    

    @Override
    public void create(Compositor compositor) {
        try {
            archivoEscritura = new RandomAccessFile(ruta, "rw");
            archivoEscritura.seek(archivoEscritura.length());
            
            archivoEscritura.writeInt(compositor.getCodigo());
            archivoEscritura.writeUTF(compositor.getNombre());
            archivoEscritura.writeUTF(compositor.getApellido());
            archivoEscritura.writeInt(compositor.getEdad());
            archivoEscritura.writeUTF(compositor.getNacionalidad());
            archivoEscritura.writeInt(compositor.getNumeroDeComposiciones());
            archivoEscritura.writeDouble(compositor.getSalario());
            List<Cancion> listaCanc = compositor.getCancionesTop100Billboard();
            for (int i = 0; i < listaCanc.size() ; i++) {
                 archivoEscritura.writeInt(listaCanc.get(i).getCodigo());
                 archivoEscritura.writeUTF(listaCanc.get(i).getTitulo());
                 archivoEscritura.writeUTF(listaCanc.get(i).getLetra());
                 archivoEscritura.writeDouble(listaCanc.get(i).getTiempoEnMinutos());
            }
            List<Cantante> listaCantante = compositor.getCliente();
            for (int i = 0; i < listaCantante.size(); i++) {
                archivoEscritura.writeInt(listaCantante.get(i).getCodigo());
                archivoEscritura.writeUTF(listaCantante.get(i).getNombre());
                archivoEscritura.writeUTF(listaCantante.get(i).getApellido());
                archivoEscritura.writeInt(listaCantante.get(i).getEdad());
                archivoEscritura.writeUTF(listaCantante.get(i).getNacionalidad());
                archivoEscritura.writeUTF(listaCantante.get(i).getNombreArtistico());
                archivoEscritura.writeUTF(listaCantante.get(i).getGeneroMusical());
                archivoEscritura.writeInt(listaCantante.get(i).getNumeroDeSencillos());
                archivoEscritura.writeInt(listaCantante.get(i).getNumeroDeConciertos());
                archivoEscritura.writeInt(listaCantante.get(i).getNumeroDeGiras());
                archivoEscritura.writeDouble(listaCantante.get(i).getSalario());
            }
            System.out.println("Tamnio del archivo : "+archivoEscritura.length()); 
            archivoEscritura.close();
         }
        catch(FileNotFoundException e){
            System.out.println("Ruta no ecncontrada");
        } catch(IOException e1){
            System.out.println("Error de Escritura");
        }
        catch (Exception e) {
            System.out.println("Error General");
        }
    }

    @Override
    public Compositor read(int codigo) {
        try {
            archivoLectura = new RandomAccessFile(ruta, "r");
            int bytesPorCompositor = 1941;
            long numCompositores = archivoLectura.length() / bytesPorCompositor;

            for (int i = 0; i < numCompositores; i++) {
                archivoLectura.seek(i * bytesPorCompositor);
                int codigoCantante = archivoLectura.readInt();

                if (codigoCantante == codigo) {
                    String nombre = archivoLectura.readUTF();
                    String apellido = archivoLectura.readUTF();
                    int edad = archivoLectura.readInt();
                    String nacionalidad = archivoLectura.readUTF();
                    int numeroComposiciones = archivoLectura.readInt();
                    double salario = archivoLectura.readDouble();
                    Compositor compositor = new Compositor(numeroComposiciones, codigo, nombre, apellido, edad, nacionalidad, salario);
                    for (int j = 0; j < 10; j++) {
                        int codigoComp = archivoLectura.readInt();
                        String titulo = archivoLectura.readUTF();
                        String letra = archivoLectura.readUTF();
                        double tiempo = archivoLectura.readDouble();
                        Cancion cancion = new Cancion(codigoComp, titulo, letra,tiempo );
                        compositor.agregarCancion(cancion); 
                        
                    }
                    
                    for (int j = 0; j < 10; j++) {
                        int codigoCan = archivoLectura.readInt();
                        String nombreCan = archivoLectura.readUTF();
                        String apellidoCan = archivoLectura.readUTF();
                        int edadCan = archivoLectura.readInt();
                        String nacionalidadCan = archivoLectura.readUTF();
                        String nombreARCan = archivoLectura.readUTF();
                        String generoMusical = archivoLectura.readUTF();
                        int numeroSencillos = archivoLectura.readInt();
                        int numeroConciertos = archivoLectura.readInt();
                        int numeroGiras = archivoLectura.readInt();
                        double salarioCan = archivoLectura.readDouble();
                        Cantante cantante = new Cantante(nombreARCan, generoMusical, numeroSencillos, numeroConciertos, numeroGiras, codigoCan, nombreCan, apellidoCan, edadCan, nacionalidadCan, salarioCan);
                        compositor.agregarClientE(cantante); 
                    }
                    
                    archivoLectura.close();

                    return compositor ;
            }
        }
        archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada");
        } catch (IOException e1) {
            System.out.println("Error de Lectura");
        } catch (Exception e) {
            System.out.println("Error General");
    }

    return null; 
    }

    @Override
    public void update(Compositor compositor) {
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            int bytesPorCompositor = 1941 ;
            long numCompositores = archivo.length() / bytesPorCompositor;
            for (int i = 0; i < numCompositores; i++) {
                archivo.seek(i * bytesPorCompositor);
                int codigoCompositor = archivo.readInt();
                if (codigoCompositor == compositor.getCodigo()) {
                    //archivo.writeInt(cantante.getCodigo());
                    archivo.writeUTF(compositor.getNombre());
                    archivo.writeUTF(compositor.getApellido());
                    archivo.writeInt(compositor.getEdad());
                    archivo.writeUTF(compositor.getNacionalidad());
                    archivo.writeInt(compositor.getNumeroDeComposiciones());
                    archivo.writeDouble(compositor.getSalario());
                    List<Cancion> listaCanc = compositor.getCancionesTop100Billboard();
                    System.out.println("Lista del update = "+ listaCanc.toString());
                    for (int j = 0; i < listaCanc.size(); j++) {
                        archivo.writeInt(listaCanc.get(j).getCodigo());
                        archivo.writeUTF(listaCanc.get(j).getTitulo());
                        archivo.writeUTF(listaCanc.get(j).getLetra());
                        archivo.writeDouble(listaCanc.get(j).getTiempoEnMinutos());
                        
                    }
                    
                    List<Cantante> listaCantante = compositor.getCliente();
                    for (int j = 0; j < 10; j++) {
                        archivo.writeInt(listaCantante.get(i).getCodigo());
                        archivo.writeUTF(listaCantante.get(i).getNombre());
                        archivo.writeUTF(listaCantante.get(i).getApellido());
                        archivo.writeInt(listaCantante.get(i).getEdad());
                        archivo.writeUTF(listaCantante.get(i).getNacionalidad());
                        archivo.writeUTF(listaCantante.get(i).getNombreArtistico());
                        archivo.writeUTF(listaCantante.get(i).getGeneroMusical());
                        archivo.writeInt(listaCantante.get(i).getNumeroDeSencillos());
                        archivo.writeInt(listaCantante.get(i).getNumeroDeConciertos());
                        archivo.writeInt(listaCantante.get(i).getNumeroDeGiras());
                        archivo.writeDouble(listaCantante.get(i).getSalario());
                    }
                    
                    archivo.close();
                    return; 
            }
        }

        archivo.close();
        //System.out.println("No ser encontr cantante");
        } catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada");
            } catch (IOException e1) {
                System.out.println("Error de Lectura");
            } catch (Exception e) {
                System.out.println("Error General");
        }
    }

    @Override
    public void delete(Compositor compostior) {
        /*try{
            RandomAccessFile archivito = new RandomAccessFile(ruta, "rw");

            int bytesPorCompositor = 1941;
            long numCantantes = archivito.length() / bytesPorCompositor;
            System.out.println(archivito.length());

            for (int i = 0; i < numCantantes; i++) {
                archivito.seek(i * bytesPorCompositor);
                int codigoCantante = archivito.readInt();
                
                if (codigoCantante == compostior.getCodigo()) {
                    long posicionActual = i * bytesPorCompositor;
                    long posicionSiguiente = (i + 1) * bytesPorCompositor;
                    long bytesRestantes = archivito.length() - posicionSiguiente;

                    byte[] buffer = new byte[(int) bytesRestantes];
                    archivito.read(buffer);
                    archivito.seek(posicionActual);
                    archivito.write(buffer);
                    archivito.setLength(archivito.length() - bytesPorCompositor);
                    archivito.close();
                    return; 
                }
            }
            System.out.println(archivito.length());
            archivito.close();
            //System.out.println("No Existe el codgo");
        }catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada");
        } catch (IOException e1) {
            System.out.println("Error de Lectura/Escritura");
        } catch (Exception e) {
            System.out.println("Error General");
        }*/
         try {
        RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
        int bytesPorCompositor = 1941; // Asegúrate de que este valor coincida con el tamaño de registro que utilizaste al escribir los datos

        long numCompositores = archivo.length() / bytesPorCompositor;
        boolean encontrado = false;

        for (int i = 0; i < numCompositores; i++) {
            archivo.seek(i * bytesPorCompositor);

            int codigo = archivo.readInt();

            if (codigo == compostior.getCodigo()) {
                encontrado = true;
                // Encontramos el registro a eliminar, movemos los registros siguientes para sobrescribirlo
                for (int j = i + 1; j < numCompositores; j++) {
                    archivo.seek(j * bytesPorCompositor);
                    byte[] datos = new byte[bytesPorCompositor];
                    archivo.readFully(datos);
                    archivo.seek((j - 1) * bytesPorCompositor);
                    archivo.write(datos);
                }

                archivo.setLength((numCompositores - 1) * bytesPorCompositor); // Reducimos el tamaño del archivo eliminando el último registro sobrante
                break; // Terminamos el ciclo ya que hemos eliminado el registro
            }
        }

        archivo.close();

        if (encontrado) {
            System.out.println("Compositor con código " + compostior.getCodigo() + " eliminado correctamente.");
        } else {
            System.out.println("Compositor con código " + compostior.getCodigo() + " no encontrado.");
        }
    } catch (FileNotFoundException e) {
        System.out.println("Ruta no encontrada");
    } catch (IOException e1) {
        System.out.println("Error de Lectura/Escritura");
    } catch (Exception e) {
        System.out.println("Error General");
    }
    }
    
    @Override
    public Compositor buscarPorTituloDeCancion(String valor) {
        List<Compositor> listaCompositor = this.findAll();
        for (Compositor compositor : listaCompositor) { // iteramos sobre cada persona en la lista
            if (compositor instanceof Compositor) { // si la persona es un compositor
                for (Cancion cancion : compositor.getCancionesTop100Billboard()) { // iteramos sobre las canciones del compositor
                    if (cancion.getTitulo().equals(valor)) { 
                        return compositor; // solo se imprime la primera coincidencia, por lo que terminamos el método con un return
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public List<Compositor> findAll() {
        List<Compositor> listaCompositores = new ArrayList<>();

    try {
        RandomAccessFile archivoLectura = new RandomAccessFile(ruta, "r");
        int bytesPorCompositor = 1941; 

        long numCompositores = archivoLectura.length() / bytesPorCompositor;
        System.out.println(archivoLectura.length());
        for (int i = 0; i < numCompositores; i++) {
            archivoLectura.seek(i * bytesPorCompositor);

            int codigo = archivoLectura.readInt();
            String nombre = archivoLectura.readUTF();
            String apellido = archivoLectura.readUTF();
            int edad = archivoLectura.readInt();
            String nacionalidad = archivoLectura.readUTF();
            int numeroComposiciones = archivoLectura.readInt();
            double salario = archivoLectura.readDouble();

            Compositor compositor = new Compositor(numeroComposiciones, codigo, nombre, apellido, edad, nacionalidad, salario);
            System.out.println(archivoLectura.length());
            for (int j = 0; j < 10; j++) {
                int codigoCancion = archivoLectura.readInt();
                String titulo = archivoLectura.readUTF();
                String letra = archivoLectura.readUTF();
                double tiempo = archivoLectura.readDouble();
                Cancion cancion = new Cancion(codigoCancion, titulo, letra, tiempo);
                compositor.agregarCancion(cancion);
            }

            for (int j = 0; j < 10; j++) {
                int codigoCantante = archivoLectura.readInt();
                String nombreCantante = archivoLectura.readUTF();
                String apellidoCantante = archivoLectura.readUTF();
                int edadCantante = archivoLectura.readInt();
                String nacionalidadCantante = archivoLectura.readUTF();
                String nombreArtistico = archivoLectura.readUTF();
                String generoMusical = archivoLectura.readUTF();
                int numeroSencillos = archivoLectura.readInt();
                int numeroConciertos = archivoLectura.readInt();
                int numeroGiras = archivoLectura.readInt();
                double salarioCantante = archivoLectura.readDouble();

                Cantante cantante = new Cantante(nombreArtistico, generoMusical, numeroSencillos, numeroConciertos, numeroGiras, codigoCantante, nombreCantante, apellidoCantante, edadCantante, nacionalidadCantante, salarioCantante);
                compositor.agregarClientE(cantante);
            }

            listaCompositores.add(compositor);
        }

        archivoLectura.close();
    } catch (FileNotFoundException e) {
        System.out.println("Ruta no encontrada");
    } catch (IOException e1) {
        System.out.println("Error de Lectura");
    } catch (Exception e) {
        System.out.println("Error General");
    }

    return listaCompositores;
    }
    
}
